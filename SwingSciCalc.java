import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingSciCalc extends JFrame implements ActionListener {
    private JTextField display;
    private double firstOperand = 0;
    private String operator = "";
    private boolean isNewInput = true;

    public SwingSciCalc() {
        setTitle("Scientific Calculator");
        setLayout(new BorderLayout());

        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "C", "sqrt", "sin", "cos",
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            if (cmd.matches("[0-9]") || cmd.equals(".")) {
                if (isNewInput) {
                    display.setText(cmd);
                    isNewInput = false;
                } else {
                    display.setText(display.getText() + cmd);
                }
            } 
            else if (cmd.equals("C")) {
                display.setText("0");
                firstOperand = 0;
                operator = "";
                isNewInput = true;
            } 
            else if (cmd.equals("sin") || cmd.equals("cos") || cmd.equals("sqrt")) {
                double value = Double.parseDouble(display.getText());
                if (cmd.equals("sin")) value = Math.sin(Math.toRadians(value));
                else if (cmd.equals("cos")) value = Math.cos(Math.toRadians(value));
                else if (cmd.equals("sqrt")) value = Math.sqrt(value);
                
                display.setText(String.valueOf(value));
                isNewInput = true; 
            } 
            else if (cmd.equals("=")) {
                double secondOperand = Double.parseDouble(display.getText());
                double result = 0;
                
                switch (operator) {
                    case "+": result = firstOperand + secondOperand; break;
                    case "-": result = firstOperand - secondOperand; break;
                    case "*": result = firstOperand * secondOperand; break;
                    case "/": 
                        if (secondOperand == 0) throw new ArithmeticException("Div by zero");
                        result = firstOperand / secondOperand; 
                        break;
                }
                display.setText(String.valueOf(result));
                isNewInput = true;
            } 
            else {
                firstOperand = Double.parseDouble(display.getText());
                operator = cmd;
                isNewInput = true;
            }
        } catch (Exception ex) {
            display.setText("Error");
            isNewInput = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingSciCalc());
    }
}