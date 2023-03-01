package practice;

public class QuickUnionUF {
    private int[] prnt;

    public QuickUnionUF(int N) {
        for (int i = 0; i < N; i++) {
            prnt[i] = i;
        }
    }

    public int find(int i) {
        while(i != prnt[i]) {
            i = prnt[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        prnt[i] = j;
    }
}
