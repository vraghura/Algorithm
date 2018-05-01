package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vigneshwarraghuram on 10/28/17.
 */
public class LongestSubstring {

    /*public static void main(String[] args) {

        String input = "abcabcbb";

        int n = input.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(input, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }

        }
        System.out.println(ans);public
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }*/


    public static void main(String[] args) {

        String input = "abcdabcbb";

        int n = input.length();

        Set<Character> set = new HashSet<>();

        int ans = 0, i = 0, j = 0;

        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (set.contains(input.charAt(j))) {
                set.remove(input.charAt(i++));
            } else {
                set.add(input.charAt(j++));
                ans = Math.max(ans, j - i);
            }
        }
        System.out.println(ans);
    }
}