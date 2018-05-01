package LeetCode;

/**

 https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems


 */
public class MinimumWindowSubstring {


    public static void main(String[] args) {

        System.out.println(minWinSubString("ADOBECODEBANC", "ABC"));
    }

    /*

    https://leetcode.com/problems/minimum-window-substring/discuss/26902/O(N)-JAVA-Sliding-Window-solution-with-explanation

     */
    private static String minWinSubString(String s, String t) {

        char[] s_array = s.toCharArray();

        int[] map = new int[128];
        for (Character ch : t.toCharArray()) {
            map[ch]++;
        }

        int count = t.length(), start = 0, end = 0, minLength = Integer.MAX_VALUE, minStart = 0;
        while (end < s.length()) {
            if (map[s_array[end]] > 0) {   // t has this character
                count--;
            }
            map[s_array[end]]--;
            while (count == 0)   //window matches
            {
                if ((end - start + 1) < minLength) {
                    minLength = end - start + 1;
                    minStart = start;
                }
                map[s_array[start]]++;     // start go left
                if (map[s_array[start]] > 0) {    // remove a character which t has
                    count++;           //Cause for those Characters t doesn't have, map[thisCharacter] are at most 0
                }
                start++;
            }
            end++;

        }
        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(minStart, minStart + minLength);
    }
}