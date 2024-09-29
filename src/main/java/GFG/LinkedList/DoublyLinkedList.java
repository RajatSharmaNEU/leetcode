package GFG.LinkedList;

public class DoublyLinkedList {
    // Class Node
    public static class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            this.data = d;
        }
    }
    // Insert at beginning
    public static Node insertBegin(Node head, int data) {
        Node temp = new Node(data);
        temp.next = head;
        if(head.prev != null) {
            head.prev = temp;
        }
        return temp;
    }
    // Insert at end
    public static Node insertEnd(Node head, int data) {
        Node temp = new Node(data);
        if(head == null) {
            return temp;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = temp;
        temp.prev = curr;
        return head;
    }
    // Insert at given position
    public static Node insertPosition(Node head, int pos, int data) {
        if(pos <= 0) {
            return head;
        }

        Node temp = new Node(data);
        if(pos == 1) {
            temp.next = head;
            head.prev = temp;
            return temp;
        }

        Node curr = head;

        for (int i = 1; i <= pos - 2; i++) {
            if(curr != null) {
                curr = curr.next;
            }
        }

        if(curr == null) {
            return head;
        }

        // curr -> temp -> curr.next
        curr.next.prev = temp;
        temp.next = curr.next;
        curr.next = temp;
        temp.prev = curr;
        return head;
    }
    // Delete Last
    public static Node deleteEnd(Node head) {
        if(head == null || head.next == null) {
            return null;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.prev.next = null;
        return head;
    }
    // Delete Head
    public static Node deleteHead(Node head) {
        if(head == null || head.next == null) {
            return null;
        }

        head = head.next;
        head.prev = null;
        return head;
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
