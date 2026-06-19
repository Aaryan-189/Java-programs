
public class swap {
    public static void main(String[] args) {
        int a = 5, b = 10;
        a = a + b; 
        b = a - b;
        a = a - b; 
        System.out.println("a: " + a + ", b: " + b);
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("a: " + a + ", b: " + b);
    }
}