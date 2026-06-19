import java.util.*;
public class Calculator{
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First No. : ");
        float a = sc.nextFloat();
        System.out.print("Enter Second No. : ");
        float b = sc.nextFloat();
        System.out.print("Enter your choice ");
        char o = sc.next().charAt(0);
        if(o=='+'){
            System.out.print((a+b));
        }
        else if(o=='-'){
            System.out.print((a-b));
        }
        else if(o=='*'){
            System.out.print((a*b));
        }
        else if(o=='/'){
            System.out.print((a/b));
        }
        else if(o=='%'){
            System.out.print((a%b));
        }
        else {
            System.out.println("Invalid operator!");
        }
    }
}