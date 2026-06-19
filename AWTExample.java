import java.awt.*;
import java.awt.event.*;
class AWTExample implements ActionListener{
    Frame f;
    Button b;
    TextField tf;
    AWTExample(){
        f = new Frame("AWT Example");
        tf = new TextField();
        tf.setBounds(50,50,150,30);
        b = new Button("Click Me");
        b.setBounds(50,100,80,30);
        b.addActionListener(this);
        f.add(tf);
        f.add(b);
        f.setSize(300, 200);
        f.setLayout(null);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                f.dispose();
            }
        });
    }
    public void actionPerformed(ActionEvent e){
        tf.setText("Aaryan");
    }
    public static void main(String[] args){
        new AWTExample();
    }
}