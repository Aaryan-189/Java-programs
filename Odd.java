import java.util.*;
public class Odd{
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        for(int i=1; i<=n; i+=2){
            System.out.print(i + " ");
        }
    }
}