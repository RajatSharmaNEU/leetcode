package GFG.LinkedList;

import java.util.HashSet;

public class DetectLoop {
    // Problem - Takes an extra auxiliary space
    public static boolean detectLoopUsingHashing(SinglyLinkedList.Node head) {
        HashSet<SinglyLinkedList.Node> hashSet = new HashSet<>();
        SinglyLinkedList.Node curr = head;
        while (curr != null) {
            if(hashSet.contains(curr)) {
                return true;
            }
            hashSet.add(curr);
            curr = curr.next;
        }

        return false;
    }

    public static boolean deleteLoopFloyd(SinglyLinkedList.Node head) {
        SinglyLinkedList.Node slow = head;
        SinglyLinkedList.Node fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList.Node head = new SinglyLinkedList.Node(10);
        head.next = new SinglyLinkedList.Node(20);
        head.next.next = new SinglyLinkedList.Node(30);
        head.next.next.next = new SinglyLinkedList.Node(40);
        head.next.next.next.next = head;

        System.out.println(detectLoopUsingHashing(head));
        System.out.println(deleteLoopFloyd(head));
    }
}
