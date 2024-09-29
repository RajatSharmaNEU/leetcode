package GFG.LinkedList;

public class DetectAndRemoveLoop {
    public static void removeLoop(SinglyLinkedList.Node head) {
        SinglyLinkedList.Node slow = head;
        SinglyLinkedList.Node fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            return;
        }

        slow = head;

        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        if(fast == head) {
            while (fast.next != head) {
                fast = fast.next;
            }
        }

        fast.next = null;
    }

    public static void main(String[] args) {
        SinglyLinkedList.Node head = new SinglyLinkedList.Node(10);
        head.next = new SinglyLinkedList.Node(20);
        head.next.next = new SinglyLinkedList.Node(30);
        head.next.next.next = new SinglyLinkedList.Node(40);
        head.next.next.next.next = head;

        // SinglyLinkedList.traverse(head);
        removeLoop(head);
        SinglyLinkedList.traverse(head);

        SinglyLinkedList.Node head1 = new SinglyLinkedList.Node(10);
        head1.next = new SinglyLinkedList.Node(20);
        head1.next.next = new SinglyLinkedList.Node(30);
        head1.next.next.next = new SinglyLinkedList.Node(40);
        head1.next.next.next.next = new SinglyLinkedList.Node(50);
        head1.next.next.next.next.next = new SinglyLinkedList.Node(60);
        head1.next.next.next.next.next.next = new SinglyLinkedList.Node(70);
        head1.next.next.next.next.next.next.next = new SinglyLinkedList.Node(80);
        head1.next.next.next.next.next.next.next.next = head1.next.next;

        //SinglyLinkedList.traverse(head1);
        removeLoop(head1);
        SinglyLinkedList.traverse(head1);
    }
}
