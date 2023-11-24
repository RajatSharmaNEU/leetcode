package GFG.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Practice {
    private static class Job {
        int deadline;
        int profit;

        Job(int d, int p) {
            this.deadline = d;
            this.profit = p;
        }
    }

    private int maxProfit(Job[] jobs) {
        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit - o1.profit;
            }
        });

        int[] jobSchedule = new int[jobs.length];

        for (int i = 0; i < jobs.length; i++) {
            int currDeadline = jobs[i].deadline - 1;
            while (currDeadline >= 0) {
                if(jobSchedule[currDeadline] == 0) {
                    jobSchedule[currDeadline] = jobs[i].profit;
                    break;
                }
                currDeadline--;
            }
        }
        System.out.println(Arrays.toString(jobSchedule));
        return Arrays.stream(jobSchedule).sum();
    }

    public static void main(String[] args) {
        Job[] jobs = new Job[]{
                new Job(4, 50),
                new Job(1, 5),
                new Job(1, 20),
                new Job(5, 10),
                new Job(5, 80),
        };

        Practice jobSequencing = new Practice();
        System.out.println(jobSequencing.maxProfit(jobs));
        // [0, 0, 0, 0, 0]
        // [20, 0, 10, 50, 80] ~ 160
    }
}
