package GFG.Greedy;

import java.util.PriorityQueue;

public class HuffmanCode {
    // Node Structure
    private static class Node {
        char ch;
        int freq;
        Node left;
        Node right;

        Node(char c, int f, Node l, Node r) {
            ch = c;
            freq = f;
            left = l;
            right = r;
        }
    }

    private void createHuffmanTree(char[] arr, int[] freq) {
        // PQ with min freq sorted ~ minimum first
        PriorityQueue<Node> h = new PriorityQueue<>((n1, n2) -> n1.freq - n2.freq);
        for (int i = 0; i < arr.length; i++) { // O(n log n)
            h.add(new Node(arr[i], freq[i], null, null));
        }

        while (h.size() > 1) {// O(n log n)
            Node l = h.poll();
            Node r = h.poll();
            h.add(new Node('$', l.freq + r.freq, l, r));
        }

        System.out.println("H size" + h.size());
        printRec(h.peek(), "");
    }

    private void printRec(Node root, String s) { // O(n)
        if (root.ch != '$') {
            System.out.println(root.ch + "" + s);
            return;
        }
        printRec(root.left, s + '0');
        printRec(root.right, s + '1');
    }

    public static void main(String[] args) {
        char[] arr = new char[]{'a', 'd', 'e', 'f'};
        int[] freq = new int[]{30, 40, 80, 60};

        HuffmanCode huffmanCode = new HuffmanCode();

        huffmanCode.createHuffmanTree(arr, freq);
    }
}
