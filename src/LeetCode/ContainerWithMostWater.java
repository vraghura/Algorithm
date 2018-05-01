package LeetCode;

public class ContainerWithMostWater {


    public static void main(String[] args) {

            int[] height = {3,0,0,2,0,4};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
