package GFG.Trie;

public class DistinctRowsCount {

    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
        boolean isEnd;
    }

    static TrieNode root = new TrieNode();

    public static boolean insertRow(TrieNode root, int[] matrixRow) {

        TrieNode curr = root;
        boolean flag = true;

        for (int i = 0; i < matrixRow.length; i++) {
            if(curr.children[matrixRow[i]] == null) {
                curr.children[matrixRow[i]] = new TrieNode();
                flag = false;
            }
            curr = curr.children[matrixRow[i]];
        }

        return flag;
    }

    public static int distinctRowsCount(int[][] matrix) {
        int count = 0;

        for (int row = 0; row < matrix.length; row++) {
            if (insertRow(root, matrix[row])) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 0, 0},
                {1, 1, 1},
                {1, 0, 0},
                {1, 1, 1}
        };

        System.out.println(distinctRowsCount(matrix));
    }
}
