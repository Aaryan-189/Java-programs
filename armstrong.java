import java.util.Scanner;

public class armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();       
        int temp = num;
        int sum = 0;
        int digits = String.valueOf(num).length();
        
        while (temp > 0) {
            int lastDigit = temp % 10;
            sum += Math.pow(lastDigit, digits);
            temp /= 10;
        }     
        if (sum == num) {
            System.out.println(num + " is an Armstrong number.");
        } else {
            System.out.println(num + " is not an Armstrong number.");
        }
    }
}