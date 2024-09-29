package GFG.LinkedList;

public class RemoveDuplicateSorted {
    public static SinglyLinkedList.Node removeDuplicate(SinglyLinkedList.Node head) {
        SinglyLinkedList.Node curr = head;

        while (curr!= null && curr.next != null) {
            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList.Node head = new SinglyLinkedList.Node(10);
        SinglyLinkedList.insertEnd(head, 20);
        SinglyLinkedList.insertEnd(head, 20);
        SinglyLinkedList.insertEnd(head, 30);
        SinglyLinkedList.insertEnd(head, 30);
        SinglyLinkedList.insertEnd(head, 30);
        SinglyLinkedList.insertEnd(head, 40);

        head = removeDuplicate(head);
        SinglyLinkedList.traverse(head);
    }
}
