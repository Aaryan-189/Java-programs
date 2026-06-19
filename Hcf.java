import java.util.*;
public class Hcf{
    public static int Hcf(int a,int b){
        int h=1;
        int n=a>=b?b:a;
        for (int i=1; i<=n; i++){
            if(a%i==0 && b%i==0){
                h=i;
            }
        }
        return h;
    }
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a no. = ");
        int a = sc.nextInt();
        System.out.print("Enter another no. = ");
        int b = sc.nextInt();
        System.out.print(Hcf(a,b));
    }
}