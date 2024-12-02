import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class main{
    main(){
        JFrame frame = new JFrame("Arithmetic calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 450);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());

        JTextField text1 = new JTextField(10);
        JTextField text2 = new JTextField(10);
        JTextField text3 = new JTextField(10);
        JTextField text4 = new JTextField(10);

        JLabel label1 = new JLabel("First number");
        JLabel label2 = new JLabel("Second number");
        JLabel label3 = new JLabel("Operator");
        JLabel label4 = new JLabel("Result");

        text4.setEditable(false);

        JButton btn = new JButton("=");

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String fun = text3.getText();
                double num;
                double num1 = Double.parseDouble(text1.getText());
                double num2 = Double.parseDouble(text2.getText());

                switch(fun){
                    case "+":
                        num = num1 + num2;
                        text4.setText(String.valueOf(num));
                        break;
                    case "-":
                        num = num1 - num2;
                        text4.setText(String.valueOf(num));
                        break;
                    case "*":
                        num = num1 * num2;
                        text4.setText(String.valueOf(num));
                        break;
                    case "/":
                        num = num1 / num2;
                        text4.setText(String.valueOf(num));
                        break;

                }
            }
        });
        frame.add(label1);
        frame.add(text1);
        frame.add(label2);
        frame.add(text2);
        frame.add(label3);
        frame.add(text3);
        frame.add(label4);
        frame.add(text4);
        frame.add(btn);


        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new main();
    }
}