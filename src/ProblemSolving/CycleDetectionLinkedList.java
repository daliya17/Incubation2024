package ProblemSolving;

public class CycleDetectionLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next =new Node(5);
        head.next.next.next.next.next = head.next.next;
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(Node head){
        Node slow=head, fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
