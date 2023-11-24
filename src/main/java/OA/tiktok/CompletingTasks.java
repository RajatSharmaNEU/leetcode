package OA.tiktok;

// n users wants to complete m tasks
// tasks[m] represent user m proficient in task, i.e. would take 1 minute
// other non-proficient user will take 2 minute
// Condition
// No two user can work on one task
// data follow 1 indexing

import java.util.HashMap;

// Calculate minTime require for n user to complete all m tasks
public class CompletingTasks {

    private int minTimeRequired(int n, int m, int[] tasks) {
        HashMap<Integer, Integer> taskCountMap = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            taskCountMap.put(tasks[i], taskCountMap.get(tasks[i]) == null ? 1 :  taskCountMap.get(tasks[i]) + 1);
        }

        System.out.println(taskCountMap.get(2));

        return -1;
    }

    public static void main(String[] args) {
        int n1 = 2;
        int m1 = 4;
        int[] tasks1 = new int[]{1, 1, 2, 1,};

        int n2 = 3;
        int m2 = 6;
        int[] tasks2 = new int[]{1, 2, 3, 2, 2, 2,};


        CompletingTasks completingTasks = new CompletingTasks();
        int result1 = completingTasks.minTimeRequired(n1, m1, tasks1);
        System.err.println(result1 == 3 ? "passed" : "failed");

        int result2 = completingTasks.minTimeRequired(n2, m2, tasks2);
        System.err.println(result2 == 3 ? "passed" : "failed");

    }
}
