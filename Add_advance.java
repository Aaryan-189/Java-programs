import java.util.*;
public class Add_advance{
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int a=0, b=0, c=0;
        do{
            System.out.print("Enter 1 to continue and 0 to end : ");
            int x = sc.nextInt();
            if(x!=1){
                break;
            }
            System.out.print("Enter n : ");
            int n = sc.nextInt();
            if(n>0){
                a += 1;
            }
            else if(n<0){
                b += 1;
            }
            else{
                c += 1;
            }
        }while (true);
        System.out.print("No. of Positive no = "+ a +"\nNo. of Negative no = "+ b +"\nNo. of Zero = "+ c);
    }
}