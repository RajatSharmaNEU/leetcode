package GFG.LinkedList;


import java.util.LinkedList;

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

    private static Integer getMiddle(LinkedList<Integer> list) {
        if(list.isEmpty()){
            return null;
        }

        int slow = 0, fast = 0;

        while (fast < list.size() - 1) {
            slow++;
            fast += 2;
        }

        return list.get(slow);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        // 10 20 30 40
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);

        System.out.println(getMiddle(linkedList));

        SinglyLinkedList.Node head = new SinglyLinkedList.Node(10);
        SinglyLinkedList.insertEnd(head, 20);
        SinglyLinkedList.insertEnd(head, 30);
        SinglyLinkedList.insertEnd(head, 40);
        SinglyLinkedList.insertEnd(head, 50);

        findMiddle(head);
    }
}
