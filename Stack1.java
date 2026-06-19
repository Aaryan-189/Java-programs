import java.util.ArrayDeque;
import java.util.Deque;

public class Stack1 {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop()); 
        System.out.println("Empty or not : " + stack.isEmpty());
    }
}           