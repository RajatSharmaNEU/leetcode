package GFG.LinkedList;

public class CircularLinkedList {
    // Class Node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert at beginning
    public static Node insertBegin(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            temp.next = temp;
            return temp;
        }

        // rather than traversing and find last node
        // Update data of head and make it point to temp
        temp.next = head.next;
        head.next = temp;

        int t = head.data;
        head.data = temp.data;
        temp.data = t;

        return head;
    }

    // Insert at end
    public static Node insertEnd(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            temp.next = temp;
            return temp;
        }

        // rather than traversing and find last node
        // Update data of head and make it point to temp

        temp.next = head.next;
        head.next = temp;

        int t = temp.data;
        temp.data = head.data;
        head.data = t;
        return temp;
    }

    // Insert at given position
    // Delete Last
    public static Node deleteEnd(Node head) {
        if (head == null || head.next == head) {
            return null;
        }

        Node curr = head;
        do {
            curr = curr.next;
        } while (curr.next.next != head);

        curr.next = head;
        return head;
    }

    // Delete First
    public static Node deleteHead(Node head) {
        if (head == null || head.next == head) {
            return null;
        }
        head.data = head.next.data;
        head.next = head.next.next;

        return head;
    }

    // Delete Kth
    public static Node deleteKth(Node head, int k) {
        if (head == null) {
            return null;
        }

        if(k == 1) {
            return deleteHead(head);
        }

        Node curr = head;

        for (int i = 1; i <= k-2; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;
    }
    // Traversal
    public static void traverse(Node head) {
        if (head == null) {
            return;
        }

        Node curr = head;
        do {
            System.out.println(curr.data);
            curr = curr.next;
        } while (curr != head);
    }

    // Search
    public static int search(Node head, int x) {
        int pos = 1;
        Node curr = head;
        while (curr.next!= head) {
            if(curr.data == x) {
                return pos;
            }
            pos++;
            curr = curr.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertBegin(head, 20);
        head = insertBegin(head, 15);
        head = insertBegin(head, 10);
        head = insertEnd(head, 30);
        traverse(head);

        System.out.println("Position of 15 is " + search(head, 15));

        head = deleteHead(head);
        System.out.println("--After Delete Head--");
        traverse(head);
        System.out.println("Position of 15 is " + search(head, 15));

        head = deleteEnd(head);
        System.out.println("--After Delete End--");
        traverse(head);
        System.out.println("Position of 15 is " + search(head, 15));
    }
}
