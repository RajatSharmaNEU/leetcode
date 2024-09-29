package GFG.LinkedList;

public class MiddleElement {
    public static void findMiddle(SinglyLinkedList.Node head) {
        SinglyLinkedList.Node slow = head;
        SinglyLinkedList.Node fast = head;

        if(head == null) return;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle Element is " + slow.data);
    }

    public static void main(String[] args) {
        SinglyLinkedList.Node head = new SinglyLinkedList.Node(10);
        SinglyLinkedList.insertEnd(head, 20);
        SinglyLinkedList.insertEnd(head, 30);
        SinglyLinkedList.insertEnd(head, 40);

        findMiddle(head);
    }
}
