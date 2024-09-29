package GFG.LinkedList;

public class ReverseKElements {
    public static SinglyLinkedList.Node reverse(SinglyLinkedList.Node head, int k) {
        if(head == null) return null;

        SinglyLinkedList.Node prev = null;
        SinglyLinkedList.Node curr = head;

        for (int i = 0; i < k; i++) {
            if (curr != null) {
                SinglyLinkedList.Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
        }

        head.next = reverse(curr, k);
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

        head = reverse(head, 3);
        SinglyLinkedList.traverse(head);
    }
}
