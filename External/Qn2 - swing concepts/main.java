/* Write a program to display a frame with 2 radio buttons, 1 textfield and I button. The first radio button should be named bit 1 and the second should be named bit 0.
1. If neither one is selected, the text field should display 0.
2. If both are selected, it should display 3.
3. If only bit 1 is selected, it displays 2.
4. If only bit 0 is selected, it displays 1.
The displayed value should change when a radio button is selected or unselected and the button is pressed. */

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