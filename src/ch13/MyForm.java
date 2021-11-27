package ch13;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.*;
import javax.swing.*;

public class MyForm {

    private JFrame frame;

    public static void main(String[] args) {
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        MyForm form = new MyForm();
        form.show();
    }

    MyForm() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel bottomPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        JPanel centralPanel = new JPanel();

        Container content = frame.getContentPane();

        content.add(BorderLayout.SOUTH, bottomPanel);
        content.add(BorderLayout.EAST, rightPanel);
        content.add(BorderLayout.CENTER, centralPanel);

        JButton btnOk = new JButton("Ок");
        btnOk.setDefaultCapable(true);
        btnOk.setSize(40, 30);
        JButton btnReturn = new JButton("Повторить");
        JButton btnCancel = new JButton("Отменить");

        rightPanel.add(btnOk, BorderLayout.NORTH);
        rightPanel.add(btnReturn, BorderLayout.NORTH);
        rightPanel.add(btnCancel, BorderLayout.NORTH);
    }

    private void show() {
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}