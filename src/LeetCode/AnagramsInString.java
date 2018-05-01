package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class AnagramsInString {

    public static void main(String[] args) {


        System.out.println(minWinSubString("cbaebabacd", "abc"));
    }

    /*

    https://leetcode.com/problems/minimum-window-substring/discuss/26902/O(N)-JAVA-Sliding-Window-solution-with-explanation

     */
    public static List<Integer> minWinSubString(String s, String t) {

        char[] s_array = s.toCharArray();

        List<Integer> result = new ArrayList<>();
        int[] map = new int[128];
        for (Character ch : t.toCharArray()) {
            map[ch]++;
        }

        int counter = t.length(), start = 0, end = 0;
        while (end < s.length()) {
            if (map[s_array[end]] > 0) {   // t has this character
                counter--;
            }
            map[s_array[end]]--;
            while (counter == 0) {
                char tempc = s.charAt(start);
                map[tempc]++;
                if (map[tempc]>0) {
                        counter++;
                }
                if (end - start + 1  == t.length()) {
                    result.add(start);
                }
                start++;
            }
            end++;
        }

        return result;
    }
}