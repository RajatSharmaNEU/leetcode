package problems.binarySearch;

public class FirstBadVersion {

    public static int badVersion;

    public static boolean isBadVersion(int n) {
        return n >= badVersion ? true : false;
    }

    public static int Solution(int n, int bad) {
        badVersion = bad;

        int low = 0, high = n;

        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if(isBadVersion(mid)){
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        System.out.println(Solution(5, 4) == 4);
        System.out.println(Solution(2, 1) == 1);
        System.out.println(Solution(1, 1) == 1);
    }
}
