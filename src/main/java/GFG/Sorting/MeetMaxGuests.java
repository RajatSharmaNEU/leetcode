package GFG.Sorting;

import java.util.Arrays;
import java.util.Map;

public class MeetMaxGuests {
    public static int findMaxGuestMeet(int[] arrival, int[] departure) {
        int n = arrival.length;
        Arrays.sort(arrival);
        Arrays.sort(departure);

        // initial state of the party
        int arr = 1, dep = 0, curr = 1, res = 1;

        while (arr < n && dep < n) {
            if(arrival[arr] <= departure[dep]) {
                curr++;
                arr++;
            } else {
                curr--;
                dep++;
            }

            res = Math.max(curr, res);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arrival = new int[]{900, 600, 700};
        int[] departure = new int[]{1000, 800, 730};

        System.out.println(findMaxGuestMeet(arrival, departure));
    }
}
