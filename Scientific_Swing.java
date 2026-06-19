import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Scientific_Swing extends JFrame implements ActionListener {
    private JTextField screen = new JTextField("0");
    private boolean start = true;
    private String operator = "=";
    private double result = 0;

    public Scientific_Swing() {
        setTitle("Java Scientific Calc");
        setSize(400, 550);
        setLayout(new BorderLayout(10, 10));

        screen.setEditable(false);
        screen.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(screen, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "sqrt", "sin", "cos", "tan",
            "log", "x^y", "C", "Exit"
        };

        for (String b : buttons) {
            JButton btn = new JButton(b);
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("Exit")) {
            System.exit(0);
        } else if (cmd.equals("C")) {
            result = 0;
            operator = "=";
            start = true;
            screen.setText("0");
        } else if ("0123456789.".contains(cmd)) {
            if (start) {
                screen.setText(cmd);
                start = false;
            } else {
                screen.setText(screen.getText() + cmd);
            }
        } else {
            calculate(Double.parseDouble(screen.getText()), cmd);
            start = true;
        }
    }

    private void calculate(double x, String cmd) {
        if (cmd.equals("sqrt")) result = Math.sqrt(x);
        else if (cmd.equals("sin")) result = Math.sin(Math.toRadians(x));
        else if (cmd.equals("cos")) result = Math.cos(Math.toRadians(x));
        else if (cmd.equals("tan")) result = Math.tan(Math.toRadians(x));
        else if (cmd.equals("log")) result = Math.log10(x);
        else {
            if (operator.equals("+")) result += x;
            else if (operator.equals("-")) result -= x;
            else if (operator.equals("*")) result *= x;
            else if (operator.equals("/")) result /= x;
            else if (operator.equals("x^y")) result = Math.pow(result, x);
            else if (operator.equals("=")) result = x;
            operator = cmd;
        }
        screen.setText("" + result);
    }

    public static void main(String[] args) {
        new Scientific_Swing();
    }
}