package GFG.LinkedList;

public class Practice {
    public static SinglyLinkedList.Node reverseKElements(SinglyLinkedList.Node head, int k) {
        if(head == null) {
            return null;
        }

        SinglyLinkedList.Node prev = null, curr = head;
        SinglyLinkedList.Node next = curr.next;

        int count = k;

        while (curr != null && count-- > 0) {
            curr.next = prev;
            prev = curr;
            curr = next;

            if(next != null) {
                next = next.next;
            }
        }

        head.next = reverseKElements(curr, k);

        return prev;
    }

    public static void main(String[] args) {
        SinglyLinkedList.Node head = new SinglyLinkedList.Node(10);
        SinglyLinkedList.insertEnd(head, 20);
        SinglyLinkedList.insertEnd(head, 30);
        SinglyLinkedList.insertEnd(head, 40);
        SinglyLinkedList.insertEnd(head, 50);
        SinglyLinkedList.insertEnd(head, 60);
        SinglyLinkedList.insertEnd(head, 70);

        head = reverseKElements(head, 3);
        SinglyLinkedList.traverse(head);
    }
}
