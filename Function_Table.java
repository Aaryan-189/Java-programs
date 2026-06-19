import java.util.*;
public class Function_Table{
    public static String table(int n){
        for (int i=1; i<=10; i++){
            System.out.println(n + " * " + i + " = " + (n*i));
        }
        return ("Complete");
    }
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a no. = ");
        int n = sc.nextInt();
        System.out.print(table(n));
    }
}