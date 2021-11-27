package ch06.dot_com_bust;
import java.util.*;

public class TestDotCom {
       
    public static void main(String[] args) {
        DotCom dc = new DotCom();
        dc.setName("test.com");
        ArrayList<String> loc = new ArrayList<String>();
        loc.add("A2");
        loc.add("A3");
        loc.add("A4");
        dc.setLocationCells(loc);
        boolean isTestOk = true;
        String[] userInput = {"A1", "A2", "A5", "A3", "A4"};
        int testCounts = userInput.length;
        String[] expResults = {"Мимо", "Попал", "Мимо", "Попал", "Потопил"};
        
        for (int i = 0; i < testCounts; i++) {
            String factRes = dc.checkYourself(userInput[i]);
            String expRes = expResults[i];
            boolean locTestRes = factRes.equals(expRes);
            isTestOk = isTestOk && locTestRes;
            showLocalTestResult(expRes, factRes, locTestRes);
        }
        
        System.out.println(isTestOk ? "Тест пройден!" : "Тест не пройден!");
    }  
    
    private static void showLocalTestResult(String expRes, String factRes,
        boolean testRes) {
        String outputLine = "Ожидали  : %s %nПолучили : %s %nРезультат: %s %n";
        System.out.println(String.format(
                outputLine, expRes, factRes, testRes ? "Ок" : "Ошибка!"));
    }
}
