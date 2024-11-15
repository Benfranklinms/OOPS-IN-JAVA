/* Create a swing gui application in Java using swing.
It should have 2 buttons, find and check.
And 3 text fields
In the first text field we enter a character 'a' or a word 's',
In the second text field we enter a file name.
If the find button is pressed the first word in the file starting with 'a' is displayed in the third text field.
When the check button is pressed the number of occurrences of the word m in the file is displayed in the third text field. */

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main{
    public main(){
        JFrame frame = new JFrame("Find and check");
        frame.setSize(300,400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField text1 = new JTextField(10);
        JTextField text2 = new JTextField(10);
        JTextField text3 = new JTextField(10);

        text3.setEditable(false);

        JButton btn1 = new JButton("Find");
        JButton btn2 = new JButton("Check");

        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Scanner sc = new Scanner(System.in);
                String s1 = text1.getText();
                String s2 = text2.getText();

                File file = new File(s2);

                BufferedReader br = null;

                try{
                    br = new BufferedReader(new FileReader(file));

                    String line;

                    while((line = br.readLine()) != null){
                        String[] words = line.split(" ");
                        for(String next : words){
                            if(next.startsWith(s1)){
                                text3.setText(next);
                                break;
                            }
                        }
                    }
                }
                catch(IOException e){
                    e.getStackTrace();
                }
                try{
                    br.close();
                }
                catch(IOException e){
                    e.getStackTrace();
                }
            }
        });

        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String s1 = text1.getText();
                String s2 = text2.getText();

                File file = new File(s2);
                BufferedReader br = null;

                try{
                    br = new BufferedReader(new FileReader(file));

                    String line;
                    int count = 0;

                    while((line = br.readLine()) != null){
                        String[] words = line.split(" ");
                        for(String next : words){
                            if(next.startsWith(s1)){
                                count++;  
                            }
                        }
                        text3.setText(String.valueOf(count));
                    }
                }
                catch(IOException e){
                    e.printStackTrace();
                }

                try{
                    br.close();
                }

                catch(IOException e){
                    e.printStackTrace();
                }
            }
        });

        frame.add(text1);
        frame.add(text2);
        frame.add(text3);
        frame.add(btn1);
        frame.add(btn2);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new main();
    }
}