package GoldmanSachs;

public class ContainerWater {
    // Time Complexity - O(n)
    // Space Complexity - O(1)

    public static int maxArea(int[] height) {
        // two pointer approach
        // start with extreme and move left or right which is smaller
        // calculate max area at each step

        int low = 0;
        int high = height.length - 1;
        int max = 0;

        while(low < high) {
            int minHeight = Math.min(height[low], height[high]);
            int area = minHeight * (high - low);
            max = Math.max(max, area);

            // if(minHeight == height[low]) {
            //     low++;
            // } else {
            //     high--;
            // }

            // Optimization
            while(low < high && height[low] <= minHeight) {
                low++;
            }

            while(low < high && height[high] <= minHeight) {
                high--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
