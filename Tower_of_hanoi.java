import java.util.*;
public class Tower_of_hanoi{
    public static void Tower_of_hanoi(int n, String A, String B, String C){
        if(n==1){
            System.out.println("Transfer "+ n +" From "+ A +" to "+ B);
            return;
        }
        Tower_of_hanoi(n-1, A, C, B);
        System.out.println("Transfer "+ n +" From "+ A +" to "+ B);

        Tower_of_hanoi(n-1, B, A, C);
        
    }
    public static void main(String arg[]){
        int n = 4;
        Tower_of_hanoi(n, "A", "B", "C");
    }
}