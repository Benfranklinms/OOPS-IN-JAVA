/* Create a GUI with a Textbox for getting a count N value from
user and a PRINT button. When clicking on "PRINT" button,
pass the value of count N to two threads T1 and T2. T1 thread
should print the string "Thrikkakara" for N times in console
and T2 thread should print the string "Kochi" for N times in
console. Show the o/p with synchronization. */


import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main{
    public main(){
        JFrame frame = new JFrame("With Syncronization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter a number : ");

        JTextField text = new JTextField(10);

        JButton btn = new JButton("Print");


        frame.add(label);
        frame.add(text);
        frame.add(btn);

        frame.setVisible(true);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int num = Integer.parseInt(text.getText());

                Object lock = new Object();

                Thread t1 = new Thread(new Runnable(){
                    public void run(){
                        synchronized(lock){
                            int i;
                            for(i = 0; i < num; i++){
                                System.out.println("Thrikkakara");
                            }
                        }
                    }
                });

                Thread t2 = new Thread(new Runnable() {
                    int i;
                    public void run(){
                        synchronized(lock){
                            for(i = 0; i < num; i++){
                                System.out.println("Kochi");
                            }
                        }
                    }
                });

                t1.start();
                t2.start();
            }
        });
    }
    public static void main(String[] args) {
        new main();
    }
}