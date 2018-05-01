package LeetCode;

public class MaximunSubarray {


    public static void main(String[] args) {
        MaximunSubarray subarray = new MaximunSubarray();
        int nums[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int nums1[] = new int[]{7,1,6,4,3,1};
       // System.out.println(subarray.maxSubArray(nums));
     //   System.out.println(subarray.maxSubArrayDP(nums));
        System.out.println(subarray.stock(nums1));
    }

    private int stock(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int p:nums) {
            min = Math.min(min, p);
            max = Math.max(p-min, max);
        }

        return max;
    }

    public int maxSubArray(int[] nums) {
        int maxSoFar=nums[0], maxEndingHere=nums[0];
        for (int i=1;i<nums.length;i++){
            maxEndingHere= Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public int maxSubArrayDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = Math.max(nums[i] + dp[i - 1] , nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
