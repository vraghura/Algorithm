package LeetCode;

/**
 * Created by vigneshwarraghuram on 11/4/17.
 */
public class Atoi {

    public static void main(String[] args) {

        System.out.println(myAtoi("123"));
    }

    public static int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if (str.length() == 0) return 0;

        //2. Remove Spaces
        while (str.charAt(index) == ' ' && index < str.length())
            index++;

        //3. Handle signs
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        //4. Convert number and avoid overflow
        while (index < str.length()) {

            /*

            if u subtract by char '0', the ASCII value needs not to be known.

             */
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }

}

