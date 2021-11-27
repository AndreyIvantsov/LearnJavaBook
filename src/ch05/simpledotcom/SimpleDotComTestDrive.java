package ch05.simpledotcom;
public class SimpleDotComTestDrive {

    public static void main(String[] args) {
        SimpleDotCom dot = new SimpleDotCom();
        int[] location = {2, 3, 4};
        dot.setLocationCells(location);
        String userGuess = "2";
        dot.checkYourself(userGuess);
    }
    
}
