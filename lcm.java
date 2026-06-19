public class lcm {
    public static void main(String[] args) {
        int a = 12, b = 20;
        int x = a, y = b;

        // Find GCD first
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        int gcd = x;
        int lcmResult = (a * b) / gcd;

        System.out.println("The LCM of " + a + " and " + b + " is: " + lcmResult);
    }
}