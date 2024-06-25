package GFG.BST;

public class FloorCeil {
    public static int findFloor(Node root, int k) {
        int result = -1;
        while (root != null) {
            if(root.key == k) {
                return root.key;
            } else if(k < root.key) {
                root = root.left;
            } else {
                result = root.key;
                root = root.right;
            }
        }

        return result;
    }

    public static int findCeil(Node root, int k) {
        int result = -1;
        while (root != null) {
            if(root.key == k) {
                return root.key;
            } else if(k < root.key) {
                result = root.key;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(30);

        System.out.println(findFloor(root, 14));
        System.out.println(findFloor(root, 4));
        System.out.println(findFloor(root, 30));
        System.out.println(findFloor(root, 100));

        System.out.println(findCeil(root, 14));
        System.out.println(findCeil(root, 4));
        System.out.println(findCeil(root, 30));
        System.out.println(findCeil(root, 100));
    }
}
