import java.util.Scanner;

public class Cal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        double n1 = sc.nextDouble();
        double n2 = sc.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+': System.out.println("Result: " + (n1 + n2)); break;
            case '-': System.out.println("Result: " + (n1 - n2)); break;
            case '*': System.out.println("Result: " + (n1 * n2)); break;
            case '/': 
                if (n2 != 0) System.out.println("Result: " + (n1 / n2));
                else System.out.println("Error: Division by zero.");
                break;
            default: System.out.println("Invalid operator.");
        }
    }
}