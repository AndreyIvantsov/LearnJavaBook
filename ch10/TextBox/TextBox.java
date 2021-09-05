public class TextBox {
    
    Integer i = 5;
    int j;
    
    public static void main(String[] args) {
        TextBox t = new TextBox();
        t.go();
    }
    
    public void go() { 
        j = i;
        System.out.println(j);
        System.out.println(i);
    }
}
