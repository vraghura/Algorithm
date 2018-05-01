package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FourSum {

    public static void main(String[] args) {


      //  int[] input = {1, 0, -1, 0, -2, 2};

        int[] input = {0,0,0,0};
       System.out.println(find4SumWithTarget(input,0));
    }



    private static List<List<Integer>> find4SumWithTarget(int[] num, int target) {

        int length = num.length;

        List<List<Integer>> result = new ArrayList<>();

        if (length < 4) return result;

        // Sort the array
        Arrays.sort(num);
        for (int i = 0; i < length - 3; i++) {
            if(i==0 || num[i]!= num[i-1]) {
                for (int j = i + 1; j < length - 2; j++) {
                    if(j == i + 1 || num[j]!= num[j-1]) {
                        int start = j + 1;
                        int end = length - 1;
                        int newTarget = target - (num[i] + num[j]);
                        while (start < end) {
                            if ((num[start] + num[end]) == newTarget) {
                                result.add(Arrays.asList(num[i], num[j], num[start], num[end]));
                                start++;
                                end--;
                                while (start < end && num[start] == num[start - 1]) start++;
                                while (start < end && num[end] == num[end + 1]) end--;
                            } else if (num[start] + num[end] < newTarget) {
                                start++;
                            } else {
                                end--;
                            }
                        }
                    }
                }
            }

        }
        return result;
    }
}