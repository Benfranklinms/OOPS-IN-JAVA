import java.util.*;
import java.util.concurrent.Flow;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main{
    public main(){
        JFrame frame = new JFrame("Print");
        frame.setSize(300, 400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Enter count : ");
        JTextField field = new JTextField(10);
        JButton btn = new JButton("Print");

        frame.add(label);
        frame.add(field);
        frame.add(btn);

        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int count = Integer.parseInt(field.getText());
                Thread t1 = new Thread(new Runnable() {
                    public void run(){
                        int i;
                        for(i = 0; i < count; i++){
                            System.out.println("Thrikkakara");
                        }
                    }
                });
                Thread t2 = new Thread(new Runnable() {
                    public void run(){
                        int i;
                        for(i = 0; i < count; i++){
                            System.out.println("Kochi");
                        }
                    }
                });
                t1.start();
                t2.start();
            }
        });
        frame.setVisible(true);
    }

    public static void main(String args[]){
        new main();
    }
}
