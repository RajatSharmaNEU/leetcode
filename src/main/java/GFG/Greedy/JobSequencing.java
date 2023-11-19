package GFG.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {

    private static class Job {
        int deadline;
        int profit;

        Job(int d, int p) {
            this.deadline = d;
            this.profit = p;
        }
    }

    private int maxProfit(Job[] jobs) {
        // Sort Jobs based on profit
        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit - o1.profit;
            }
        });

        boolean[] jobsPicked = new boolean[jobs.length];
        int result = 0;

        // find slot for job
//        for (int i = 0; i < jobs.length; i++) {
//            // find available slot
//            int j = jobs[i].deadline - 1;
//            while (jobsPicked[j] == true) {
//                if(j > 0) {
//                    j--;
//                } else {
//                    break;
//                }
//            }
//
//            if(jobsPicked[j] == false) {
//                System.out.println(j + "--" + jobs[i].profit);
//                result = result + jobs[i].profit;
//                jobsPicked[j] = true;
//            }
//        }

        // Find slots for jobs
        for (int i = 0; i < jobs.length; i++) {
            // Find available slot starting from the job's deadline
            int deadline = jobs[i].deadline;
            for (int j = Math.min(deadline - 1, jobsPicked.length - 1); j >= 0; j--) {
                if (!jobsPicked[j]) {
                    System.out.println(j + "--" + jobs[i].profit);
                    result += jobs[i].profit;
                    jobsPicked[j] = true;
                    break; // Exit the loop once a slot is found
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Job[] jobs = new Job[]{
                new Job(4, 50),
                new Job(1, 5),
                new Job(1, 20),
                new Job(5, 10),
                new Job(5, 80),
        };

        JobSequencing jobSequencing = new JobSequencing();
        System.out.println(jobSequencing.maxProfit(jobs));
        // [0, 0, 0, 0, 0]
        // [20, 0, 10, 50, 80] ~ 160
    }
}
