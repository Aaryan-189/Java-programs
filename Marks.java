import java.util.*;
public class Marks{
    public static void main (String[] arg){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter 1 to continue or 0 to end : ");
            int n = sc.nextInt();
            if(n==1){
                System.out.print("Enter marks out of 100 : ");
                float m = sc.nextFloat();
                if (m >= 90) {
                    System.out.println("This is good ");
                } else if (m >= 60 && m <= 89) {
                    System.out.println("This is also good ");
                } else {
                    System.out.println("This is good as well ");
                }
            }
            else{
                System.out.print("Thank you");
                break;
            }
        } while (true) ;
    }
}