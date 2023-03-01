package practice;

public class LinkedList<Item> {
    // Add
    private void add(Item item) {
        head = new Element(item, head);
    }

    // Remove
    private Item remove() throws Exception {
        if (head == null) {
            throw new Exception();
        }

        head = head.next;
        return head.item;
    }

    // getHead
    private Element getHead() {
        return isEmpty() ? null : head;
    }

    // isEmpty
    private boolean isEmpty() {
        return head == null;
    }

    private class Element {
        Element(Item i, Element n) {
            item = i;
            next = n;
        }

        final Item item;
        final Element next;
    }

    private Element head = null;
}
