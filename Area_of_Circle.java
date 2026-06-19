import java.util.*;
public class Area_of_Circle{
    public static void main(String[] arg){
    System.out.print("Radius = ");
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    double circumference = 2 * 3.14 * r;
    double area = 3.14 * r * r;  
    System.out.println("Circumference = " + circumference);
    System.out.print("Area = " + area);
    }
}