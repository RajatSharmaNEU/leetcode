package GAMAM.Pattern;

public class ContainerMaxWater {
    public static int maxArea(int[] height) {
        // Two pointer approach

        int low = 0, high = height.length - 1;
        int lowMax = height[low], highMax = height[high];
        int maxArea = 0;

        while (low < high) {
            if (height[low] < lowMax) {
                low++;
                continue;
            }

            if (height[high] < highMax) {
                high--;
                continue;
            }

            if (height[low] < height[high]) {
                maxArea = Math.max(maxArea, height[low] * (high - low));
                highMax = height[high];
                low++;
            } else {
                maxArea = Math.max(maxArea, height[high] * (high - low));
                lowMax = height[low];
                high--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
