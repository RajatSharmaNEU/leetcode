package GFG.LinkedList;

public class SortedInsert {
    public static SinglyLinkedList.Node sortedInsert(SinglyLinkedList.Node head, int x) {
        SinglyLinkedList.Node temp = new SinglyLinkedList.Node(x);
        if(head == null) {
            return temp;
        }

        if(x < head.data) {
            temp.next = head;
            return temp;
        }

        SinglyLinkedList.Node curr = head;
        while (curr.next != null && curr.next.data < x) {
            curr = curr.next;
        }

        temp.next = curr.next;
        curr.next = temp;
        return head;
    }
    public static void main(String[] args) {
        SinglyLinkedList.Node head = new SinglyLinkedList.Node(10);
        SinglyLinkedList.insertEnd(head, 20);
        SinglyLinkedList.insertEnd(head, 30);
        SinglyLinkedList.insertEnd(head, 40);
        SinglyLinkedList.traverse(head);

        System.out.println("Sorted Insert");
        sortedInsert(head, 25);
        SinglyLinkedList.traverse(head);
    }
}
