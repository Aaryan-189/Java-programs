import java.util.*;
public class Max_Min{
    public static void main(String arg[]){
        Scanner sc =new Scanner(System.in);
        int size = sc.nextInt();
        int[] marks = new int[size];
        for(int i=0; i<size; i++){
            marks[i] = sc.nextInt();
        }
        int min=marks[0],max=marks[0];
        for(int i=0; i<size; i++){
            if(marks[i]<min){
                min=marks[i];
            }
            if(marks[i]>max){
                max=marks[i];
            }
        }
        System.out.println("Max "+ max);
        System.out.println("Min "+ min);
    }
}