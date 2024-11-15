import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main{
    public main(){

        JFrame frame = new JFrame("String tokenizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());

        JTextField text = new JTextField(10);

        JButton btn = new JButton("Read");

        btn.addActionListener((ActionListener) new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                File file = new File("destination.txt");

                BufferedWriter bw = null;
                String str1 = text.getText();
                StringTokenizer str = new StringTokenizer(str1);
                int serialNumber = 111;
                try{
                    bw = new BufferedWriter(new FileWriter(file));
                    while(str.hasMoreTokens()){
                        bw.write(serialNumber + " " +str.nextToken());
                        bw.newLine();
                        serialNumber++;
                    }
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                try{
                    bw.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        });

        frame.add(text);
        frame.add(btn);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new main();
    }
}