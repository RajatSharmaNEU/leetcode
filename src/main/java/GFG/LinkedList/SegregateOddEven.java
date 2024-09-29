package GFG.LinkedList;

public class SegregateOddEven {
    public static SinglyLinkedList.Node segregate(SinglyLinkedList.Node head) {
        // Use two linkedlist even start and end, odd start and end
        SinglyLinkedList.Node es = null, ee = null, os = null, oe = null;

        for (SinglyLinkedList.Node curr = head; curr != null ; curr = curr.next) {
            int data = curr.data;

            if(data % 2 == 0) {
                if(es == null) {
                    es = curr;
                    ee = curr;
                } else {
                    ee.next = curr;
                    ee = ee.next;
                }
            } else {
                if(os == null) {
                    os = curr;
                    oe = curr;
                } else {
                    oe.next = curr;
                    oe = oe.next;
                }
            }
        }

        if(os == null || es == null) {
            return head;
        }

        ee.next = os;
        oe.next = null;

        return es;
    }
    public static void main(String[] args) {
        SinglyLinkedList.Node head = new SinglyLinkedList.Node(10);
        head.next = new SinglyLinkedList.Node(5);
        head.next.next = new SinglyLinkedList.Node(4);
        head.next.next.next = new SinglyLinkedList.Node(3);
        head.next.next.next.next = new SinglyLinkedList.Node(6);

        SinglyLinkedList.traverse(head);

        head = segregate(head);
        System.out.println("After Segregation - Even and Odd");
        SinglyLinkedList.traverse(head);
    }
}
