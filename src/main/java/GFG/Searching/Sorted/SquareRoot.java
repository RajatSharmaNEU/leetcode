package GFG.Searching.Sorted;

public class SquareRoot {
    public static int getSquareRoot(int n) {
        int low = 1;
        int high = n;
        int res = -1;
        while (low <= high) {
            int mid = (high + low) / 2;
            int midSq = mid * mid;
            if( midSq == n) {
                return mid;
            } else if (midSq > n) {
                high = mid-1;
            } else {
                low = mid + 1;
                res = mid;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(getSquareRoot(4));
        System.out.println(getSquareRoot(14));
        System.out.println(getSquareRoot(25));
    }
}
