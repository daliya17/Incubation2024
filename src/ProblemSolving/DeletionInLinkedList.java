package ProblemSolving;

public class DeletionInLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);
        printLinkedList(head);
        Node deleted = deleteNode(head, 5);
        printLinkedList(deleted);
        Node deleteHead = deleteNode(head,1);
        printLinkedList(deleteHead);
        Node deleteFromEnd = deleteNode(deleteHead,10);
        printLinkedList(deleteFromEnd);
    }

    public static Node deleteNode(Node head, int key) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == key)
            return temp.next;
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null)
            return head;
        prev.next = temp.next;
        return head;
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
