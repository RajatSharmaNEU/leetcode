package GFG.String;

import java.util.Arrays;

public class LeftMostNonRepeat {

    private int findIndex(String string) {
        boolean[] count = new boolean[256];
        int result = Integer.MAX_VALUE;

        for (int i = string.length()-1; i >= 0 ; i--) {
            if(count[string.charAt(i)] == false) {
                count[string.charAt(i)] = true;
                result = Math.min(result, i);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        String string = "geeksforgeeks";
        LeftMostNonRepeat leftMostNonRepeat = new LeftMostNonRepeat();
        System.out.println(leftMostNonRepeat.findIndex(string));
    }
}
