package GFG.LinkedList;

public class SinglyLinkedList {
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
    public static Node insertBegin(Node head, int x) {
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }

    // Insert at end
    public static Node insertEnd(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            return temp;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }

    // Insert at given position
    public static Node insertPosition(Node head, int pos, int x) {
        Node temp = new Node(x);
        // Invalid position
        if(pos <= 0) {
            return head;
        }
        // if new position is beginning
        if(pos == 1) {
            temp.next = head;
            return temp;
        }

        // if new position is in-between or end
        // find Node one position before and add new Node in its next

        Node curr = head;
        for (int i = 1; i <= pos - 2; i++) {
            // Invalid position
            if(curr != null) {
                curr = curr.next;
            }
        }
        if(curr == null) {
            return head;
        }

        temp.next = curr.next;
        curr.next = temp;
        return head;
    }
    // Delete Last
    public static Node deleteEnd(Node head) {
        if(head == null || head.next == null) {
            return null;
        }

        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }

        curr.next = null;
        return head;
    }
    // Delete Head
    public static Node deleteHead(Node head) {
        if(head == null) {
            return null;
        }
        return head.next;
    }
    // Traversal
    public static void traverse(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    // Search
    public static int search(Node head, int x) {
        int pos = 1;
        Node curr = head;
        while (curr!= null) {
            if(curr.data == x) {
                return pos;
            }
            pos++;
            curr = curr.next;
        }
        return -1;
    }


    public static void main(String[] args) {
        Node head = new Node(20);
        head = insertBegin(head, 10);
        head = insertEnd(head, 30);
        head = insertPosition(head, 2, 15);
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
