//package query;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {

    JTextField display;
    double num1 = 0;
    String operator = "";

    public CalculatorGUI() {
        setTitle("Scientific Calculator");
        setSize(420, 500);
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 22));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(6, 4, 10, 10));

        String buttons[] = {
                "sin", "cos", "tan", "sqrt",
                "log", "x²", "%", "AC",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            if (cmd.matches("[0-9.]")) {
                display.setText(display.getText() + cmd);
            }
            else if (cmd.equals("AC")) {
                display.setText("");
                num1 = 0;
                operator = "";
            }
            else if (cmd.matches("[+\\-*/]")) {
                num1 = Double.parseDouble(display.getText());
                operator = cmd;
                display.setText("");
            }
            else if (cmd.equals("=")) {
                double num2 = Double.parseDouble(display.getText());
                double result = 0;

                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": result = num1 / num2; break;
                }

                display.setText(String.valueOf(result));
            }
            else if (cmd.equals("sin")) {
                double n = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.sin(Math.toRadians(n))));
            }
            else if (cmd.equals("cos")) {
                double n = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.cos(Math.toRadians(n))));
            }
            else if (cmd.equals("tan")) {
                double n = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.tan(Math.toRadians(n))));
            }
            else if (cmd.equals("sqrt")) {
                double n = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.sqrt(n)));
            }
            else if (cmd.equals("log")) {
                double n = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.log10(n)));
            }
            else if (cmd.equals("x²")) {
                double n = Double.parseDouble(display.getText());
                display.setText(String.valueOf(n * n));
            }
            else if (cmd.equals("%")) {
                double n = Double.parseDouble(display.getText());
                display.setText(String.valueOf(n / 100));
            }
        } 
        catch (Exception ex) {
            display.setText("Error");
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}