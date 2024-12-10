package CoreJava.Collections;

import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        // LinkedList as a Queue
        Queue<String> linkedListQueue = new LinkedList<>();
        linkedListQueue.offer("John");
        linkedListQueue.offer("Alice");
        linkedListQueue.offer("Bob");
        System.out.println("LinkedList Queue: " + linkedListQueue);

        System.out.println("Poll: " + linkedListQueue.poll()); // Removes and returns the head
        System.out.println("Queue after poll: " + linkedListQueue);

        // PriorityQueue Example (Elements ordered by natural ordering or custom comparator)
        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("Banana");
        priorityQueue.offer("Apple");
        priorityQueue.offer("Cherry");
        System.out.println("PriorityQueue: " + priorityQueue); // Orders elements by natural order
        priorityQueue.poll();
        System.out.println("PriorityQueue after poll: " + priorityQueue);

        // ArrayDeque Example (Double-ended queue)
        Deque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.offerFirst("X");
        arrayDeque.offerLast("Y");
        System.out.println("ArrayDeque: " + arrayDeque);
        System.out.println("First: " + arrayDeque.peekFirst());
        System.out.println("Last: " + arrayDeque.peekLast());
        arrayDeque.offerFirst("A");
        arrayDeque.offerLast("Z");
        System.out.println("ArrayDeque after offer: " + arrayDeque);
        System.out.println("Poll: "+arrayDeque.pollFirst());
        System.out.println("ArrayDeque after poll: " + arrayDeque);
    }
}
