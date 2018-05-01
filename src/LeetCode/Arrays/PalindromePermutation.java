package LeetCode.Arrays;

public class PalindromePermutation {

    public static void main(String[] args) {

        System.out.println(isPermutationOfPalindrome("Tact Coa"));
    }

    private static boolean isPermutationOfPalindrome(String input) {

        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        int count=0;
        for(char c: input.toCharArray()){
            int x = getCharNumber(c);
            if(x!= -1){
                table[x]++;
                if(table[x] % 2 == 1){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return count<=1;
    }

    private static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if(a<=val && val <=z){
            return val - a;
        }
        return -1;
    }
}
