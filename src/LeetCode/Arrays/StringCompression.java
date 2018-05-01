package LeetCode.Arrays;

public class StringCompression {


    public static void main(String[] args) {

        System.out.println(compressString("aabbccccccaaa"));
    }

    private static String compressString(String input) {

        StringBuilder sb = new StringBuilder();
        int count=0;
        for(int i=0; i<input.length(); i++ ){

            count++;
            if(i+1 >=input.length() || input.charAt(i)!=input.charAt(i+1)){
                sb.append(input.charAt(i));
                sb.append(count);
                count=0;
            }

        }
        return sb.toString();
    }
}
