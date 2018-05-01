package LeetCode;

/**
 * Created by vigneshwarraghuram on 11/4/17.
 */
public class ReverseInteger {
    public static void main(String[] args) {

        System.out.println(reverse(111));
    }

    public static int reverse(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;

            /* Check to avoid overflow
            * (newResult - tail) / 10" turns the "result * 10 + tail" back.
            * If no overflow exists, "(newResult - tail) / 10" should be equal to "result".
            * If overflow happens, they cannot be equal.
            * */

            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}
