package GoldmanSachs;

public class RobotBounded {
    public static boolean isRobotBounded(String instructions) {
        int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        int x = 0, y = 0, i = 0;

        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                x += dir[i][0];
                y += dir[i][1];
            } else if (ch == 'L') {
                i = (i + 1) % 4;
            } else {
                i = (i + 3) % 4;
            }
        }

        return (x == 0 && y == 0) || i != 0;
    }

    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
        System.out.println(isRobotBounded("GG"));
    }
}
