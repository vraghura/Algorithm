package LeetCode.Arrays;

import java.util.Arrays;

public class ArrayPartition1 {

    public static void main(String[] args) {

        ArrayPartition1 arrayPartition = new ArrayPartition1();
        int[] nums = new int[]{1,4,2,3};
        System.out.println(arrayPartition.arrayPairSum(nums));

    }


    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
