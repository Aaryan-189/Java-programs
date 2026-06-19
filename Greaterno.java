import java.util.*;
public class Greaterno{
    public static int Greater_no(int a,int b){
        int c;
        if (a>=b){
            c = a;
        }
        else{
            c = b;
        }
        return c;
    }
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a no. = ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.print(Greater_no(n1,n2));
    }
}