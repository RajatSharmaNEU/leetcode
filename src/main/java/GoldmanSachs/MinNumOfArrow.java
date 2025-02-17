package GoldmanSachs;

import java.util.Arrays;

public class MinNumOfArrow {
    public int findMinArrowShots(int[][] points) {

        // Weird Compare function
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] <= 0 && o2[1] >= 0){
                return -1;
            }
            if (o1[1] >= 0 && o2[1] <= 0){
                return 1;
            }
            return o1[1] - o2[1];
        });

        int xStart, xEnd, firstEnd = points[0][1];
        int arrow = 1;

        for(int[] point: points) {
            xStart = point[0];
            xEnd = point[1];

            if(firstEnd < xStart) {
                arrow++;
                firstEnd = xEnd;
            }
        }

        return arrow;
    }
}
