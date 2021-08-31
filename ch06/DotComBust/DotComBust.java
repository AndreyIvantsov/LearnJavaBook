import java.io.*;
import java.util.*;

public class DotComBust {

    private GameHelper helper;
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;
    private final String instructionFile = "resurces/instruction.txt"; 
    private final int comSize = 3;
    private final int criticalNumOfGuess = 18;
    
    DotComBust(String mode) {
        boolean cheaterModeOn = mode != null && mode.equals("cheater");
        helper = new GameHelper(cheaterModeOn);
    }
    
    private void setUpGame() {
        String[] names = {"Pets.com", "eToys.com", "Go2.com"};
        int countNames = names.length;
        
        for (int i = 0; i < countNames; i++) {
            DotCom dc = new DotCom();
            dc.setName(names[i]);
            dotComList.add(dc);
        } 
        
        for (DotCom dotComToSet : dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(comSize);
            dotComToSet.setLocationCells(newLocation);
        }
        
        System.out.println();
    }
    
    private void printInstruction() {
        try (FileReader fr = new FileReader(instructionFile);
            BufferedReader br = new BufferedReader(fr)) {
            String line;
            
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (IOException e) {
            System.out.println("Ошибка: Не удалось загрузить инструкцию!");
        }
        
        System.out.println();
    }
    
    private void startPlaying() {
        while (!dotComList.isEmpty()) {
            String userGuess = helper.getUserInput("Сделайте ход: ");
            checkUserGuess(userGuess);
        }
        
        finishGame();
    }
    
    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Мимо";
        
        for (DotCom dotComTest : dotComList) {
            result = dotComTest.checkYourself(userGuess);
            
            if (result.equals("Попал")) {
                break;
            }
            
            if (result.equals("Потопил")) {
                dotComList.remove(dotComTest);
                result = result + "\n";
                break;
            }
        }
        
        System.out.print("> " + result);
    }
    
    private void finishGame() {
        List<String> lines = new ArrayList<String>();
        String attempts = attemptStr(numOfGuesses);
        lines.add("\nВсе \"сайты\" ушли ко дну!");
    
        if (numOfGuesses <= criticalNumOfGuess) {
            lines.add("Это заняло у Вас всего " 
                    + numOfGuesses + attempts);
            lines.add("Вы успели выбраться до того, "
                    + "как ваши вложения утонули!\n");
        } else {
            lines.add("Это заняло у Вас довольно моного времени "
                    + numOfGuesses + attempts);
            lines.add("Рыбы водят хоровод вокруг ваших вложений!\n");
        }
        
        for (String line : lines) {
            System.out.println(line);
        }
    }
    
    private String attemptStr(int attempt) {
        String result = "попыток.";
        
        Set<String> chars = new HashSet<String>(Arrays.asList("2", "3", "4"));
        String numStr = Integer.toString(attempt);
        String lastChar = numStr.substring(numStr.length() - 1);
        
        if (chars.contains(lastChar)) {
            return " попытки.";
        }
        
        if (lastChar.equals("1") && attempt != 11) {
            return " попытку.";
        }
        
        return " попыток.";
    }
    
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
       
    public static void main(String[] args) {
        DotComBust.clearScreen();
        DotComBust game = new DotComBust(args.length > 0 ? args[0] : null);
        game.printInstruction();
        game.setUpGame();
        game.startPlaying();   
    }
}







