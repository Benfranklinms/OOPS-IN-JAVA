import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Calculator{

    private JTextField text;

    public Calculator(){
        JFrame frame = new JFrame();

        frame.setSize(300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        text = new JTextField();
        text.setHorizontalAlignment(JTextField.RIGHT);
        text.setEditable(false);
        frame.add(text, BorderLayout.NORTH);

        JPanel buttonpanel = new JPanel();
        buttonpanel.setLayout(new GridLayout(4, 4, 10, 10));
        String[] buttons = {"7", "8", "9", "/",
                            "4", "5", "6", "*",
                            "1", "2", "3", "-",
                            "0", "C", "=", "+"};
        for(String label : buttons){
            JButton button = new JButton(label);
            button.addActionListner(new ButtonClickListener());
            buttonpanel.add(button);

            frame.add(buttonpanel, BorderLayout.CENTER);
            frame.setVisible(true);
        }

        class ButtonClickListener implements ActionListner{
            public void actionPerformed(ActionEvent e){
                String command = e.getActionCommand();

                switch(command){
                    case "C":
                        text.setText(" ");
                        operator = " ";
                        break;
                    case "=":
                        

                }
            }
        }
    }
}