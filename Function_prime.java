import java.util.*;
public class Function_prime{
    public static String prime(int a){
        for(int i=2; i<a; i++){
            if (a%i==0)
            return ("Not A Prime NO. ");
        }
        return ("Prime NO. ");
    }
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a no.    ");
        int n= sc.nextInt();
        System.out.print(prime(n));
    }
}