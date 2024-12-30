package GFG.Deque;

import java.util.Arrays;

public class Practice {
    public static int findStartingPump(int[] petrol, int[] dist) {
        int totalGas = 0;
        int stationsVisited = 0;
        int result = 0;
        int index = 0;

        if(Arrays.stream(petrol).sum() - Arrays.stream(dist).sum() < 0 ) {
            return -1;
        }
        while (stationsVisited < petrol.length) {
            totalGas = totalGas + (petrol[index] - dist[index]);
            if(totalGas < 0) {
                totalGas = 0;
                stationsVisited = 0;
                result = index + 1;
            }
            index = (index + 1) % petrol.length;
            stationsVisited++;
        }

        return result + 1;
    }

    public static void main(String[] args) {
        int[] petrol = new int[]{50, 10, 60, 100};
        int[] dist = new int[]{30, 20, 100, 10};
        int[] res = new int[]{20, -10, -40, 90};

        int[] petrol1 = new int[]{4, 8};
        int[] dist1 = new int[]{5, 6};

        int[] petrol2 = new int[]{8, 9, 4};
        int[] dist2 = new int[]{5, 10, 12};

        // totalGas = 0 + (50 - 30) = 20, index = 1
        // totalGas = 20 + (10 - 20) = 10, index = 2
        // totalGas = 10 + (60 - 100) = -30 --> 0, stationVisited = 0, result = 3
        // totalGas = 0 + (100 - 10) = 90, stationVisited = 1, index = 0
        // totalGas = 90 + (50 - 30) = 110, stationVisited = 2, index = 1
        // totalGas = 110 + (10 - 20) = 100, stationVisited = 3, index = 2
        // totalGas = 100 + (60 - 100) = 60, stationVisited = 4, index = 3
        // result = 3 -->  return 4

        System.out.println(findStartingPump(petrol, dist));
        System.out.println(findStartingPump(petrol2, dist2));
        System.out.println(findStartingPump(petrol1, dist1));
    }
}
