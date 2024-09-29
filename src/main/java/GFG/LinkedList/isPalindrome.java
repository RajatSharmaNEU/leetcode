package GFG.LinkedList;

public class isPalindrome {
    public static boolean checkPalindrome(SinglyLinkedList.Node head) {
        if(head == null) {
            return true;
        }

        SinglyLinkedList.Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow now is at middle position;

        SinglyLinkedList.Node rev = Reverse.reverse(slow.next);
        SinglyLinkedList.Node curr = head;

        while (rev != null) {
            if(rev.data != curr.data) {
                return false;
            }

            rev = rev.next;
            curr = curr.next;
        }

        return true;
    }

    public static void main(String[] args) {
        SinglyLinkedList.Node head = new SinglyLinkedList.Node(10);
        SinglyLinkedList.insertEnd(head, 20);
        SinglyLinkedList.insertEnd(head, 30);
        SinglyLinkedList.insertEnd(head, 20);
        SinglyLinkedList.insertEnd(head, 10);

        System.out.println(checkPalindrome(head));
    }
}
