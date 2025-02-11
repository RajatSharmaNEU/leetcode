package GFG.Deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindCircularTour {
    public static int naive(int[] petrol, int[] dist) {
        int n = petrol.length;
        int currPetrol = 0;

        for (int i = 0; i < n; i++) {
            int start = i;
            int count = 0;
            while (count != n) {
                currPetrol = currPetrol + (petrol[start] - dist[start]);
                if(currPetrol < 0) {
                    break;
                }
                start = (start + 1) % n;
                count++;
            }

            if(count == n) {
                return start;
            }
        }

        return -1;
    }

    // Best
    public static int dequeFindCircularTour(int[] petrol, int[] dist) {
        int n = petrol.length;

        Deque<Integer> deque = new ArrayDeque<>();
        int currPetrol = 0; // Current petrol balance
        int startIndex = 0; // Starting index
        int totalPetrol = 0; // Total petrol
        int totalDist = 0; // Total distance

        for (int i = 0; i < n; i++) {
            totalPetrol += petrol[i];
            totalDist += dist[i];

            currPetrol += petrol[i] - dist[i];
            deque.addLast(i);

            // If petrol balance becomes negative, reset the deque and starting index
            if (currPetrol < 0) {
                deque.clear();
                startIndex = i + 1; // Move starting index to the next pump
                currPetrol = 0; // Reset current petrol balance
            }
        }

        // If the total petrol is less than the total distance, no tour is possible
        if (totalPetrol < totalDist) {
            return -1;
        }

        // Otherwise, the starting index is the answer
        return startIndex + 1;
    }

    public static int findStartingPump(int[] pumps, int[] distance) {
        int totalDeficit = 0; // Track overall deficit when tour is not possible
        int currentSurplus = 0; // Petrol surplus in the current window
        int startIndex = 0; // Starting index of the tour

        for (int i = 0; i < pumps.length; i++) {
            int netPetrol = pumps[i] - distance[i];
            currentSurplus += netPetrol;

            // If current surplus is negative, this means we cannot complete the tour from the current start index
            if (currentSurplus < 0) {
                totalDeficit += currentSurplus;
                startIndex = i + 1; // Move the starting point to the next pump
                currentSurplus = 0; // Reset the current surplus
            }
        }

        // Check if total petrol collected is enough to cover the total distance
        if (currentSurplus + totalDeficit >= 0) {
            return startIndex + 1; // Return starting pump index
        } else {
            return -1; // No possible starting point
        }
    }

    public static void main(String[] args) {
        int[] petrol = new int[]{4, 8, 7, 4};
        int[] dist = new int[]{6, 5, 3, 5};

        int[] petrol1 = new int[]{4, 8};
        int[] dist1 = new int[]{5, 6};

        int[] petrol2 = new int[]{8, 9, 4};
        int[] dist2 = new int[]{5, 10, 12};

        int[] petrol3 = new int[]{50, 10, 60, 100};
        int[] dist3 = new int[]{30, 20, 100, 10};



//        System.out.println(naive(petrol, dist));
//        System.out.println(dequeFindCircularTour(petrol3, dist3)); -- Incomplete implementation
        System.out.println(dequeFindCircularTour(petrol3, dist3));
//        System.out.println(findStartingPump(petrol2, dist2));
//        System.out.println(findStartingPump(petrol1, dist1));

    }
}
