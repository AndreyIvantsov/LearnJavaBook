import java.io.*;
import java.util.*;

public class GameHelper {

    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int [] grid = new int[gridSize];
    private int comCount = 0;
    private boolean cheaterModeOn;
    
    GameHelper(boolean cheaterModeOn) {
        this.cheaterModeOn = cheaterModeOn;
        if (cheaterModeOn) {
            System.out.println("Активирован режим \"Читер\"!\n");
        }
    }
    
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print("\n" +prompt + " ");
        
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        
        if (inputLine.length() == 0) {
            return null;
        } else {
            return inputLine.toLowerCase();
        }
    }

    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoohds = new String[comSize];
        String temp = null;
        int[] coords = new int[comSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;
        
        comCount++;
        int incr = 1;
        if ((comCount % 2) == 1) {
            incr = gridLength;
        }
        
        while (!success & attempts++ < 200) {
            location = (int) (Math.random() * gridSize);
            
            // Читерская подсказка во время игры
            //if (cheaterModeOn) {
            //    System.out.println("Пробуем: " + location);
            //}
            
            int x = 0;
            success = true;
            
            while (success && x < comSize) {
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;
                    
                    if (location >= gridSize) {
                        success = false;
                    }
                    
                    if (x > 0 && (location % gridLength == 0)) {
                        success = false;
                    }
                    
                } else {
                    // Читерская подсказка во время игры
                    //if (cheaterModeOn) {
                    //    System.out.println("Используется: " + location);  
                    //}
                    success = false;  
                }
            }
        }
        
        int x = 0;
        int row = 0;
        int column = 0;
        
        // Читерская подсказка во время игры
        if (cheaterModeOn) {
            System.out.print("[ "); 
        }
        
        while (x < comSize) {
            grid[coords[x]] = 1;
            row = (int) (coords[x] / gridLength);
            column = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            
            // Читерская подсказка во время игры
            if (cheaterModeOn) {
                System.out.print(alphaCells.get(x - 1) + " "); 
            }
        }
        
        // Читерская подсказка во время игры
        if (cheaterModeOn) {
            System.out.print("] ");
        }
        
        return alphaCells;
    } 
}





















