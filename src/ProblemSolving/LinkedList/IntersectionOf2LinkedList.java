package ProblemSolving.LinkedList;

public class IntersectionOf2LinkedList {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next.next = new Node(8);
        head1.next.next.next.next.next.next.next.next = new Node(9);

        Node head2 = new Node(10);
        head2.next = new Node(11);
        head2.next.next = new Node(12);
        head2.next.next.next = head1.next.next.next.next.next;
        printLinkedList(head1);
        printLinkedList(head2);

        System.out.println(getIntersectionNode(head1, head2).data);
    }

    public static Node getIntersectionNode(Node headA, Node headB) {
        Node a = headA;
        Node b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        // when a is null, then a = headB, so a will be headB

        return a;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
