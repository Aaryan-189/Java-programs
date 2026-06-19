import java.util.*;
public class Eligible{
    public static String Eligible(int a){
        String c;
        if (a>=18){
            c = "Eligible";
        }
        else{
            c = "Not Eligible";
        }
        return c;
    }
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a no. = ");
        int a = sc.nextInt();
        System.out.print(Eligible(a));
    }
}