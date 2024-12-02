import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class main{
    main(){
        JFrame frame = new JFrame("Temperature convertor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300, 400);
        frame.setLayout(new FlowLayout());

        JTextField field1 = new JTextField(10);
        JTextField field2 = new JTextField(10);
        JLabel label1 = new JLabel("Enter temp");
        JLabel label2 = new JLabel("Converted temp");
        JButton btn = new JButton("Convert");
        field2.setEditable(false);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int temp = Integer.parseInt(field1.getText());
                int cel = temp;
                int fah = (cel * 9/5) + 32;
                field2.setText(String.valueOf(fah));
            }
        });
        frame.add(label1);
        frame.add(field1);
        frame.add(label2);
        frame.add(field2);
        frame.add(btn);


        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new main();
    }
}