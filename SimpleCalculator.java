import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends Frame implements ActionListener {
    // UI Components
    TextField display;
    Button[] numberButtons = new Button[10];
    Button addBtn, subBtn, mulBtn, divBtn, eqBtn, clrBtn;
    
    // Variables for calculation
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public SimpleCalculator() {
        // 1. Frame Setup
        setTitle("AWT Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());

        // 2. Display Field
        display = new TextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        // 3. Buttons Panel (GridLayout)
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Initialize Number Buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Initialize Operator Buttons
        addBtn = new Button("+");
        subBtn = new Button("-");
        mulBtn = new Button("*");
        divBtn = new Button("/");
        eqBtn = new Button("=");
        clrBtn = new Button("C");

        // Add Listeners to Operators
        Button[] ops = {addBtn, subBtn, mulBtn, divBtn, eqBtn, clrBtn};
        for (Button b : ops) b.addActionListener(this);

        // 4. Add components to panel (Calculator Layout)
        panel.add(numberButtons[1]); panel.add(numberButtons[2]); panel.add(numberButtons[3]); panel.add(addBtn);
        panel.add(numberButtons[4]); panel.add(numberButtons[5]); panel.add(numberButtons[6]); panel.add(subBtn);
        panel.add(numberButtons[7]); panel.add(numberButtons[8]); panel.add(numberButtons[9]); panel.add(mulBtn);
        panel.add(clrBtn);           panel.add(numberButtons[0]); panel.add(eqBtn);           panel.add(divBtn);

        add(panel, BorderLayout.CENTER);

        // Close window logic
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle Number Clicks
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText() + i);
            }
        }

        // Handle Operators
        if (e.getSource() == addBtn) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        } else if (e.getSource() == subBtn) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        } else if (e.getSource() == mulBtn) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        } else if (e.getSource() == divBtn) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }

        // Handle Equals
        if (e.getSource() == eqBtn) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            display.setText(String.valueOf(result));
        }

        // Handle Clear
        if (e.getSource() == clrBtn) {
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}