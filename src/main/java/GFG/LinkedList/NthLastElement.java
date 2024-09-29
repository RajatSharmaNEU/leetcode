package GFG.LinkedList;

public class NthLastElement {
    public static void findNthLast(SinglyLinkedList.Node head, int k) {
        if(head == null || k <= 0) return;

        SinglyLinkedList.Node aheadPointer = head;
        SinglyLinkedList.Node backPointer = head;

        for (int i = 0; i < k; i++) {
            if(aheadPointer == null) return;
            aheadPointer = aheadPointer.next;
        }

        while (aheadPointer != null) {
            aheadPointer = aheadPointer.next;
            backPointer = backPointer.next;
        }

        System.out.println(backPointer.data);
    }
    public static void main(String[] args) {
        SinglyLinkedList.Node head = new SinglyLinkedList.Node(10);
        SinglyLinkedList.insertEnd(head, 20);
        SinglyLinkedList.insertEnd(head, 30);
        SinglyLinkedList.insertEnd(head, 40);


        findNthLast(head, 0);
        findNthLast(head, 1);
        findNthLast(head, 2);
        findNthLast(head, 3);
        findNthLast(head, 4);
        findNthLast(head, 5);

    }
}
