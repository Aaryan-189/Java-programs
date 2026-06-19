import java.util.*;
public class Table_of_a_no{
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a no. = ");
        int n = sc.nextInt();
        for (int i=1; i<=10; i++){
            System.out.println(n + " * " + i + " = " + (n*i));
        }
    }
}