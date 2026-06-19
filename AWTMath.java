import java.awt.*;
import java.awt.event.*;
public class AWTMath extends Frame implements ActionListener {
    TextField num1Field, num2Field, resultField;
    Button addButton, mulButton;
    public AWTMath() {
        setTitle("AWT Math Operations");
        setLayout(new FlowLayout());
        num1Field = new TextField(10);
        num2Field = new TextField(10);
        resultField = new TextField(15);
        resultField.setEditable(false);
        addButton = new Button("Add");
        mulButton = new Button("Multiply");
        add(new Label("Number 1:")); add(num1Field);
        add(new Label("Number 2:")); add(num2Field);
        add(addButton); add(mulButton);
        add(new Label("Result:")); add(resultField);
        addButton.addActionListener(this);
        mulButton.addActionListener(this);
        setSize(250, 150);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { dispose(); }
        });
    }
    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(num1Field.getText());
            double n2 = Double.parseDouble(num2Field.getText());
        
            if (e.getSource() == addButton) {
                resultField.setText(String.valueOf(n1 + n2));
            } else if (e.getSource() == mulButton) {
                resultField.setText(String.valueOf(n1 * n2));
            }
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }
    public static void main(String[] args) {
        new AWTMath();
    }
}