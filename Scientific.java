import java.awt.*;
import java.awt.event.*;

public class Scientific extends Frame implements ActionListener {
    TextField display;
    // Buttons for numbers and standard ops
    Button[] numButtons = new Button[10];
    Button addBtn, subBtn, mulBtn, divBtn, eqBtn, clrBtn, dotBtn;
    // Scientific Buttons
    Button sinBtn, cosBtn, tanBtn, logBtn, sqrtBtn, powBtn;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Scientific() {
        setTitle("Scientific Calculator");
        setSize(400, 500);
        setLayout(new BorderLayout());

        // Display
        display = new TextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Panel for Buttons
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(6, 4, 5, 5));

        // Initialize Numbers
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new Button(String.valueOf(i));
            numButtons[i].addActionListener(this);
        }

        // Initialize Operators
        addBtn = new Button("+"); subBtn = new Button("-");
        mulBtn = new Button("*"); divBtn = new Button("/");
        eqBtn = new Button("=");  clrBtn = new Button("C");
        dotBtn = new Button(".");

        // Initialize Scientific
        sinBtn = new Button("sin"); cosBtn = new Button("cos");
        tanBtn = new Button("tan"); logBtn = new Button("log");
        sqrtBtn = new Button("√");  powBtn = new Button("x^y");

        Button[] scientific = {sinBtn, cosBtn, tanBtn, logBtn, sqrtBtn, powBtn, 
                               addBtn, subBtn, mulBtn, divBtn, eqBtn, clrBtn, dotBtn};
        for (Button b : scientific) b.addActionListener(this);

        // Add to Panel - Row 1
        panel.add(sinBtn); panel.add(cosBtn); panel.add(tanBtn); panel.add(clrBtn);
        // Row 2
        panel.add(logBtn); panel.add(sqrtBtn); panel.add(powBtn); panel.add(divBtn);
        // Row 3
        panel.add(numButtons[7]); panel.add(numButtons[8]); panel.add(numButtons[9]); panel.add(mulBtn);
        // Row 4
        panel.add(numButtons[4]); panel.add(numButtons[5]); panel.add(numButtons[6]); panel.add(subBtn);
        // Row 5
        panel.add(numButtons[1]); panel.add(numButtons[2]); panel.add(numButtons[3]); panel.add(addBtn);
        // Row 6
        panel.add(dotBtn); panel.add(numButtons[0]); panel.add(new Button("+/-")); panel.add(eqBtn);

        add(panel, BorderLayout.CENTER);

        // Close Window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        // Number logic
        if (Character.isDigit(cmd.charAt(0))) {
            display.setText(display.getText() + cmd);
        } else if (cmd.equals(".")) {
            if (!display.getText().contains(".")) display.setText(display.getText() + ".");
        } else if (cmd.equals("C")) {
            display.setText("");
        }
        
        // Basic Math Operators
        else if ("+-*/x^y".contains(cmd)) {
            num1 = Double.parseDouble(display.getText());
            operator = cmd.equals("x^y") ? '^' : cmd.charAt(0);
            display.setText("");
        } 
        
        // Scientific Logic (Instant calculation)
        else if (cmd.equals("sin")) {
            display.setText(String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(display.getText())))));
        } else if (cmd.equals("cos")) {
            display.setText(String.valueOf(Math.cos(Math.toRadians(Double.parseDouble(display.getText())))));
        } else if (cmd.equals("tan")) {
            display.setText(String.valueOf(Math.tan(Math.toRadians(Double.parseDouble(display.getText())))));
        } else if (cmd.equals("log")) {
            display.setText(String.valueOf(Math.log10(Double.parseDouble(display.getText()))));
        } else if (cmd.equals("√")) {
            display.setText(String.valueOf(Math.sqrt(Double.parseDouble(display.getText()))));
        }
        
        // Equals Logic
        else if (cmd.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
                case '^': result = Math.pow(num1, num2); break;
            }
            display.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new Scientific();
    }
}