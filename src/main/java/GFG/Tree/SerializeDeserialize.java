package GFG.Tree;

import java.util.ArrayList;

public class SerializeDeserialize {
    public void serialize(Node root, ArrayList<Integer> arr) {
        if(root == null) {
            arr.add(Integer.MIN_VALUE);
            return;
        }

        serialize(root.left, arr);
        serialize(root.right, arr);
    }

    int index = 0;
    public Node deSerialize(ArrayList<Integer> arr) {
        if(index == arr.size()) {
            return null;
        }

        int val = arr.get(index++);

        if(val == Integer.MIN_VALUE) {
            return null;
        }
        Node root = new Node(val);
        root.left = deSerialize(arr);
        root.right = deSerialize(arr);

        return root;
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);

        ArrayList<Integer> result = new ArrayList<>();
        SerializeDeserialize serializeDeserialize = new SerializeDeserialize();

        serializeDeserialize.serialize(node, result);
    }
}
