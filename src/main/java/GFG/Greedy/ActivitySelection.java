package GFG.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    private static class Activity {
        int start;
        int finish;

        Activity(int s, int f) {
            this.start = s;
            this.finish = f;
        }
    }

    private int getMaximumActivitySelection(Activity[] inputs) {
        Arrays.sort(inputs, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.finish - o2.finish;
            }
        });

//        Arrays.sort(inputs, ((o1, o2) -> o1.finish - o2.finish));

        int count = 1; // consider first value as initial Activity
        int prevIndex = 0;
        for (int i = 1; i < inputs.length; i++) {
            if(inputs[i].start >= inputs[prevIndex].finish) {
                count++;
                prevIndex = i;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Activity[] input = new Activity[]{
                new Activity(12, 25),
                new Activity(10, 20),
                new Activity(20, 30),
        };

        ActivitySelection activitySelection = new ActivitySelection();
        System.out.println(activitySelection.getMaximumActivitySelection(input));
    }
}
