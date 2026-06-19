import java.util.*;
public class Circumference{
    public static float Circumference(int r){
        float c=2*(22/7)*r;
        return c;
    }
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius = ");
        int r = sc.nextInt();
        System.out.print(Circumference(r));
    }
}