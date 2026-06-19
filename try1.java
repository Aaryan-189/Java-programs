import java.util.ArrayList;

public class try1{
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
        System.out.print(arr[i]);
        list.add(arr[i]);
        }
        list.add(1, 99);
        System.out.print(list);
        list.remove(2);
        list.remove(2);
        System.out.print(list);

    }
}