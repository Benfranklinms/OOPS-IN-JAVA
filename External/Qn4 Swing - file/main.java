/* Read 3 marks of a student from an input file with following format
Roll.No  Name  Markl Mark2
111       Anu    50    50

Display the above details in a GUI when clicking on "Import data" button. Use required Textbox and labels When clicking on "Calculate" button, find total marks and display it in another text box. */


import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main{
    public main(){
        JFrame frame = new JFrame("Student details");
        frame.setSize(400, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Roll no  ");
        JTextField text1 = new JTextField(10);

        JLabel label2 = new JLabel("Name  ");
        JTextField text2 = new JTextField(10);

        JLabel label3 = new JLabel("Mark 1  ");
        JTextField text3 = new JTextField(10);

        JLabel label4 = new JLabel("Mark 2  ");
        JTextField text4 = new JTextField(10);

        JLabel label5 = new JLabel("Total  ");
        JTextField text5 = new JTextField(10);

        JButton btn1 = new JButton("Import data");
        JButton btn2 = new JButton("Calculate");

        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                File file = new File("source.txt");

                BufferedReader br = null;

                try{
                    br = new BufferedReader(new FileReader(file));
                    String line;
                    while((line = br.readLine()) != null){
                        String[] words = line.split(" ");
                            text1.setText(words[0]);
                            text2.setText(words[1]);
                            text3.setText(words[2]);
                            text4.setText(words[3]);
                    }
                    }
                    catch(IOException e){
                        JOptionPane.showMessageDialog(frame, "Error in reading line");
                    }
                }
        });

        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                int mark1 = Integer.parseInt(text3.getText());
                int mark2 = Integer.parseInt(text4.getText());

                int result = mark1 + mark2;

                text5.setText(String.valueOf(result));
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
        frame.add(label5);
        frame.add(text5);
        frame.add(btn1);
        frame.add(btn2);

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new main();
    }
}