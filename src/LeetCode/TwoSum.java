package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vigneshwarraghuram on 10/28/17.
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] input = {10,4,33,9,22,6,5};
        int target=9;

        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<input.length;i++){
            hashMap.put(input[i],i);
        }

        for(int i=0; i<input.length; i++){
            int complement = target - input[i];
            if (hashMap.containsKey(complement) && hashMap.get(complement) != i) {
                System.out.println(""+i+","+ hashMap.get(complement));
                break;
            }
        }
    }
}
