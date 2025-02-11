package GoldmanSachs;

import java.util.*;
import java.util.stream.Collectors;

// give Average of top 5 score of each students
public class HighFive {
    public static int[][] fetchTop5AvgByStudent (int[][] scores) {
        Map<Integer, List<Integer>> groupById = Arrays.stream(scores)
                .collect(Collectors.groupingBy(
                        score -> score[0], // Group by student ID
                        Collectors.mapping(score -> score[1], Collectors.toList()) // Collect scores
                ));

        List<int[]> result = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : groupById.entrySet()) {
            int studentId = entry.getKey();
            List<Integer> studentScore = entry.getValue();

            studentScore.sort(Collections.reverseOrder());

            double studentSum = studentScore.stream().limit(5).mapToInt(Integer::intValue).average().orElse(0.0);
            result.add(new int[] {studentId, (int)studentSum});
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] scores = new int[][] {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int[][] avgScoreByStudent = fetchTop5AvgByStudent(scores);

        for(int[] studentScore: avgScoreByStudent) {
            System.out.println(Arrays.toString(studentScore));
        }
    }
}
