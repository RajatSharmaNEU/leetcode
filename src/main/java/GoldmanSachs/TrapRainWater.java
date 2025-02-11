package GoldmanSachs;

public class TrapRainWater {
    public static int trap(int[] height) {
        // Two pointer
        // At each step keep left or right max value
        // update maxArea in each call

        int l = 0, r = height.length - 1;
        int lmax = -1, rmax= -1;
        int maxArea = 0;

        while(l < r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if(lmax < rmax) {
                maxArea = maxArea + (lmax - height[l]);
                l++;
            } else {
                maxArea = maxArea + (rmax - height[r]);
                r--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));
    }
}
