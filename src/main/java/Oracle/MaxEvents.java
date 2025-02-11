package Oracle;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxEvents {

    public static int maxEvents(int[][] events) {
        Arrays.sort(events,(a, b)->a[0]-b[0]);

        int day=0,index=0,n=events.length,result=0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while(!pq.isEmpty() || index<n){
            if(pq.isEmpty()){
                day = events[index][0];
            }

            // Add all events end dates which starts with current day
            while(index<n && events[index][0] == day){
                pq.offer(events[index][1]);
                index++;
            }

            // count recent ending event and move to next day
            pq.poll();
            day++;
            result++;

            // Remove all events which are ended
            while(!pq.isEmpty() && pq.peek()<day){
                pq.poll();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] eventsA = {{1, 2}, {2, 3}, {3, 4}, {1, 2}};
        int[][] eventsB = {{1, 1}, {1, 2}, {1, 3}, {1, 4}};
        System.out.println("Max events that can be attended: " + maxEvents(eventsA));
        System.out.println("Max events that can be attended: " + maxEvents(eventsB));
    }
}
