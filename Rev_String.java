import java.util.*;
public class Rev_String{
    public static void main(String arg[]){
        StringBuilder sb = new StringBuilder("Aaryan");
        int n=sb.length();
        for(int i=0; i<n; i++){
            sb.append(sb.charAt((n-i-1)));
            sb.delete(n-i-1, n-i);
        }
        System.out.print(sb);
    }
}