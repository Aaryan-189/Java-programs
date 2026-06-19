public class sdigit {
    public static void main(String[] args) {
        int num = 1234, sum = 0;
        int temp = num;

        while (temp != 0) {
            sum += temp % 10; // Get last digit
            temp /= 10;       // Remove last digit
        }
        System.out.println("Sum of digits of " + num + " is: " + sum);
    }
}