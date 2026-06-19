import java.util.*;
public class Check_ascending{
    public static void main(String arg[]){
        Scanner sc =new Scanner(System.in);
        int size = sc.nextInt();
        int[] marks = new int[size];
        for(int i=0; i<size; i++){
            marks[i] = sc.nextInt();
        }
        int a=0;
        for(int i=0; i<size-1; i++){
            if(marks[i]>marks[i+1]){
                a=1;
                break;
            }
        }
        if(a==0){
            System.out.println("Ascending Order");
        }
        else{
            System.out.println("Not In Ascending Order");
        }
    }
}