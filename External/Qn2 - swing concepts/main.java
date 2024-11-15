import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main{
    public main(){
        JFrame frame = new JFrame("Button selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);

        JRadioButton btn1 = new JRadioButton("bit 1");
        JRadioButton btn2 = new JRadioButton("bit 0");

        JTextField field = new JTextField(10);

        JButton btn = new JButton("Update");
        field.setEditable(false);

        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(btn1.isSelected() && btn2.isSelected()){
                    field.setText("3");
                }
                else if(btn1.isSelected()){
                    field.setText("2");
                }
                else if(btn2.isSelected()){
                    field.setText("1");
                }
                else{
                    field.setText("0");
                }
            }
        });

        frame.add(field);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn);

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new main();
    }
}