package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSUm {

    public static void main(String[] args) {


        int[] input = {-1, 0, 2, 1, 2, 5, -4};
        int[] input1 = {-1, 2, 1, -4};
        //System.out.println(find3Sum(input));
      //  System.out.println(find3SumWithTarget(input,8 ));

       System.out.println(threeSumClosest(input,5 ));
    }

    private static List<List<Integer>> find3Sum(int[] num) {

        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1;
                int sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) {
                            lo++;
                        }
                        while (lo < hi && num[hi] == num[hi-1]){
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum){
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }


    private static List<List<Integer>> find3SumWithTarget(int[] num, int target) {

        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || num[i] != num[i - 1]) {
                int lo = i+1, hi = num.length-1;
                int sum = 0 - num[i] + target;
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) {
                            lo++;
                        }
                        while (lo < hi && num[hi] == num[hi-1]){
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum){
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public static int threeSumClosest(int[] num, int target) {
        int closestSum = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
            }
        }
        return closestSum;
    }

}
