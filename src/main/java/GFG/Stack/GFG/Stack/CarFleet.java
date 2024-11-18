package GFG.Stack.GFG.Stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    static public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        // sort position wise, [DONT sort by time calculated]

        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int[] p : pair) {
            stack.push((double) (target - p[0]) / p[1]);
            if (stack.size() >= 2 &&
                    stack.peek() <= stack.get(stack.size() - 2))
            {
                stack.pop();
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int[] positions = new int[] {10,8,0,5,3};
        int[] speed = new int[] {2,4,1,1,3};
        int target = 12;

        System.out.println(carFleet(target, positions, speed));
    }
}
