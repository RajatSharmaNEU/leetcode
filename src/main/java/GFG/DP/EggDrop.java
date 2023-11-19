package GFG.DP;

public class EggDrop {
    private int minTrials(int k, int eggs) {

        if(k == 1 || k == 0 || eggs == 1) {
            return k;
        }

        int minTrail = Integer.MAX_VALUE;

        // let x is the trail k
        for (int x = 1; x <= k; x++) {
            // max of break, not-break
            int currTrail = Math.max(minTrials(x-1, eggs-1), minTrials(k-x, eggs));
            minTrail = Math.min(minTrail, currTrail);
        }

        return 1 + minTrail;
    }

    public static void main(String[] args) {
        EggDrop eggDrop = new EggDrop();
        System.out.println(eggDrop.minTrials(30, 2));
    }
}
