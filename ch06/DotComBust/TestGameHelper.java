import java.util.*;

public class TestGameHelper {

    public static void main(String[] args) {
        GameHelper helper = new GameHelper();
        // Тестируем метод getUserInput
        testInputIntGetUserInput(helper);
        // Тестируем метод placeDotCom
        testPlaceDotCom(helper);
    }
    
    private static void testInputIntGetUserInput(GameHelper helper) {
        String testName = "Тестирование ввода...";
        String prompt = "Введете координаты (например: A1, e5, f7)";
        System.out.println(testName);
        String result = helper.getUserInput(prompt);
        System.out.println("Введены координаты: " + result);
        System.out.println();
    }
    
    private static void testPlaceDotCom(GameHelper helper) {
        String testName = "Тестирование создания сайтов...";
        int comSize = 3;
        ArrayList<String> sites = helper.placeDotCom(comSize);
        System.out.println(testName);
        System.out.println("Созданы сайты:");
        System.out.println(sites.toString());      
    }

}
