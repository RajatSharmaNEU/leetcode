package GFG.BST;

public class BSTBasic {
    public static boolean search(Node root, int k) {
        while (root != null) {
            if (root.key == k) {
                return true;
            } else if (k < root.key) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return false;
    }

    // Remember curr will point to null and which is not a reference
    // Hence we need parent to insert new Node into left or right
    public static Node insert(Node root, int k) {
        Node temp = new Node(k);
        Node curr = root;
        Node parent = null;

        while (curr != null) {
            parent = curr;

            if (curr.key == k) {
                return root;
            }

            if (k < curr.key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (parent == null) {
            return temp;
        } else if (parent.key > k) {
            parent.left = temp;
        } else {
            parent.right = temp;
        }
        return root;
    }

    public static Node delete(Node root, int k) {
        if (root == null) {
            return null;
        }

        if (root.key > k) {
            root.left = delete(root.left, k);
        } else if (root.key < k) {
            root.right = delete(root.right, k);
        } else {
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                // find min Large value in right
                Node curr = root.right;
                while (curr != null && curr.left != null) {
                    curr = curr.left;
                }
                root.key = curr.key;
                root.right = delete(root.right, curr.key);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(18);

        System.out.println(search(root, 5));
        System.out.println(search(root, 18));
        System.out.println(search(root, 20));

        root = insert(root, 20);

        System.out.println("--- After Insert ---");

        System.out.println(search(root, 5));
        System.out.println(search(root, 18));
        System.out.println(search(root, 20));

        root = delete(root, 20);
//        System.out.println("--- After Delete ---");
        System.out.println("--- After Delete ---");

        System.out.println(search(root, 5));
        System.out.println(search(root, 18));
        System.out.println(search(root, 20));
    }
}
