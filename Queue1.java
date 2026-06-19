import java.util.Queue;
import java.util.LinkedList;

public class Queue1 {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println("Queue: " + q);
        System.out.println("Front element: " + q.peek());
        System.out.println("Removed: " + q.remove());
        System.out.println("Queue after remove: " + q);
        q.offer(40);
        System.out.println("Final Queue: " + q);
    }
}