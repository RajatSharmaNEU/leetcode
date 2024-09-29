package GFG.LinkedList;

public class Reverse {
    public static SinglyLinkedList.Node reverse(SinglyLinkedList.Node head) {
        if(head == null) return head;

        SinglyLinkedList.Node prev = null;
        SinglyLinkedList.Node curr = head;

        while (curr != null) {
            SinglyLinkedList.Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        SinglyLinkedList.Node head = new SinglyLinkedList.Node(10);
        SinglyLinkedList.insertEnd(head, 20);
        SinglyLinkedList.insertEnd(head, 30);
        SinglyLinkedList.insertEnd(head, 40);

        head = reverse(head);

        SinglyLinkedList.traverse(head);
    }
}
