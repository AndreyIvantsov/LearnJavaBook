import java.awt.*;
import javax.swing.*;


public class MyForm {

    private JFrame frame;

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        MyForm form = new MyForm();
        form.show();
    }

    MyForm() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel bottomPanel = new JPanel();
        JPanel rigthPanel = new JPanel();
        //rigthPanel.setLayout(new BorderLayout());
        JPanel centralPanel = new JPanel();

        Container content = frame.getContentPane();
        
        content.add(BorderLayout.SOUTH, bottomPanel);
        content.add(BorderLayout.EAST, rigthPanel);
        content.add(BorderLayout.CENTER, centralPanel);

        JButton btnOk = new JButton("Ок");
        btnOk.setDefaultCapable(true);
        btnOk.setSize(40, 30);
        JButton btnRenurn = new JButton("Повторить");
        JButton btnCancel = new JButton("Отменить");

        rigthPanel.add(btnOk, BorderLayout.NORTH);
        rigthPanel.add(btnRenurn, BorderLayout.NORTH);
        rigthPanel.add(btnCancel, BorderLayout.NORTH);
    }


    private void show() {
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}