package GFG.SegmentTree;

public class GetSum {
    // logN complexity
    public static int getSum(int qs, int qe, int ss, int se, int si, int[] tree) {
        // query is out of bound
        if(qs > se || qe < ss) return 0 ;

        // if query range is bigger than search range
        if(qs <= ss && qe >= se) return tree[si];

        int mid = (ss + se) / 2;

        return getSum(qs, qe, ss, mid, 2*si + 1, tree)
                + getSum(qs, qe, mid + 1, se, 2*si + 2, tree);

    }

    public static void main(String[] args) {
        int[] arr = new int[] {10, 20, 30, 40};
        int[] tree = ConstructSegmentTree.createSegmentTree(arr);

        System.out.println(getSum(0, 3, 0, 3, 0, tree));
        System.out.println(getSum(0, 2, 0, 3, 0, tree));

    }
}
