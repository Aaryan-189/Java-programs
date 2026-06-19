import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FlowEvent extends JFrame implements ActionListener {
    JTextField tf = new JTextField(15);
    JButton b1 = new JButton("One");
    JButton b2 = new JButton("Two");

    FlowEvent() {
        setLayout(new FlowLayout());
        
        add(tf);
        add(b1);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        tf.setText(e.getActionCommand());
    }

    public static void main(String[] args) {
        new FlowEvent();
    }
}