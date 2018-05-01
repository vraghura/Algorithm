package LeetCode;

public class LongestCommonPrefix {

    public static void main(String[] args) {


        String[] input = {"leet","ltets", "leetcode"};
        System.out.println(longestCommonPrefix(input));

    }

/*    private static String commonPrefix(String[] input) {
        if(input.length<1){
            return "";
        }

        int l=0;

        int r=input.length-1;

        int m = (l+r)/2;

        while( l<r){
            lgcommonprefix(l,m,input);
            lgcommonprefix(m,r,input);
        }

        return "";
    }*/




    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder lcp = new StringBuilder();
        for(int i=0;i<strs[0].length();i++){
            char c=strs[0].charAt(i);
            for(String s:strs){
                if(s.length()<i+1 || c!=s.charAt(i)){
                    return lcp.toString();
                }
            }
            lcp.append(c);
        }
        return lcp.toString();
    }
}
