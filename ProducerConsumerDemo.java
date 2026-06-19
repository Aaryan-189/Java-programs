import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int capacity = 2; // Maximum items in the queue

        // Producer Thread
        Thread producer = new Thread(() -> {
            int value = 0;
            try {
                while (true) {
                    synchronized (queue) {
                        // Wait if the queue is full
                        while (queue.size() == capacity) {
                            queue.wait();
                        }
                        System.out.println("Producer produced: " + value);
                        queue.add(value++);
                        queue.notify(); // Wake up the consumer
                        Thread.sleep(1000); // Pause for readability
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted.");
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    synchronized (queue) {
                        // Wait if the queue is empty
                        while (queue.isEmpty()) {
                            queue.wait();
                        }
                        int consumedValue = queue.poll();
                        System.out.println("Consumer consumed: " + consumedValue);
                        queue.notify(); // Wake up the producer
                        Thread.sleep(1000); // Pause for readability
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted.");
            }
        });

        producer.start();
        consumer.start();
    }
}