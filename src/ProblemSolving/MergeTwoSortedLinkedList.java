package ProblemSolving;

public class MergeTwoSortedLinkedList {
    public static void main(String[] args){
        Node head1 = new Node(1);
        head1.next = new Node(6);
        head1.next.next = new Node(7);
        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);
        head2.next.next.next = new Node(8);
        head1.next.next.next = new Node(9);
        head1.next.next.next.next = new Node(12);
        head1.next.next.next.next.next = new Node(15);
        head2.next.next.next.next = new Node(10);
        Node merged = mergeTwoLists(head1, head2);
        printLinkedList(merged);
    }

    public static Node mergeTwoLists(Node head1, Node head2){
        Node dummy = new Node(0);
        Node temp = dummy;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next = head1;
                head1=head1.next;

            }
            else {
                temp.next = head2;
                head2=head2.next;
            }
            temp=temp.next;
        }
        if (head1!=null){
            temp.next = head1;
        }
        else{
            temp.next = head2;
        }
        return dummy.next;
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
