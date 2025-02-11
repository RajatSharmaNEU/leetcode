package GAMAM.Pattern;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {

    Set<ListNode> set = new HashSet<>();

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        if(set.contains(head)) {
            return true;
        }

        set.add(head);
        return hasCycle(head.next);
    }

    public boolean hasCycleOptimized(ListNode head) {
        if(head == null) {
            return false;
        }

        // Slow and Fast Pointer
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        LinkedListCycle linkedListCycle = new LinkedListCycle();

        System.out.println(linkedListCycle.hasCycle(listNode1));
        System.out.println(linkedListCycle.hasCycleOptimized(listNode1));
    }
}
