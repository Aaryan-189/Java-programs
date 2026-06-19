import java.util.*;
public class Fibonacci{
    public static void main(String arg[]){
        int a=0, b=1, c=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a no. = ");
        int n = sc.nextInt();
        System.out.print(a +" "+ b +" ");
        for(int i=1; i<=n-2; i++){
            c=b;
            a=b-a;
            b+=a;
            System.out.print(c +" ");
        }
    }
}