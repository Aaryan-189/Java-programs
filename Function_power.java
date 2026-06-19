import java.util.*;
public class Function_power{
    public static int Function_power(int a,int b){
        int c=1;
        for(int i=1; i<=b; i++){
            c*=a;
        }
        return c;
    }
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a no. = ");
        int n1 = sc.nextInt();
        System.out.print("Enter the power = ");
        int n2 = sc.nextInt();
        System.out.print(Function_power(n1,n2));
    }
}