import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class main{
    main(){
        JFrame frame = new JFrame("No. generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());

        JTextField text1 = new JTextField(10);
        JTextField text2 = new JTextField(10);
        JTextField text3 = new JTextField(10);

        JLabel label1 = new JLabel("Current Number");
        JLabel label2 = new JLabel("Previous Number");
        JLabel label3 = new JLabel("Next Number");

        text2.setEditable(false);
        text3.setEditable(false);

        JButton btn = new JButton("Generate");

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int num = Integer.parseInt(text1.getText());
                int tex1 = num;
                int tex2 = num - 1;
                int tex3 = num + 1;
                text1.setText(String.valueOf(tex1));
                text2.setText(String.valueOf(tex2));
                text3.setText(String.valueOf(tex3));
            }
        });
        frame.add(label1);
        frame.add(text1);
        frame.add(label2);
        frame.add(text2);
        frame.add(label3);
        frame.add(text3);
        frame.add(btn);


        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new main();
    }
}