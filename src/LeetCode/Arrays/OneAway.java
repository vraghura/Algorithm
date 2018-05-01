package LeetCode.Arrays;

public class OneAway {


    public static void main(String[] args) {

        System.out.println(calculateOneEditAway("pal","pale"));
    }

    private static boolean calculateOneEditAway(String s1, String s2) {

        if(s1.length()==s2.length()){
            return oneReplaceAway(s1,s2);
        }else if(s1.length()==s2.length()+1){
            return oneInsertAway(s2,s1);
        }else{
            return oneInsertAway(s1,s2);
        }
    }

    private static boolean oneReplaceAway(String s1, String s2) {

        int count=0;
       for(int i=0; i<s1.length(); i++){
           if(count>1){
               return false;
           }
           if(s1.charAt(i)!=s2.charAt(i)){
               count++;
           }
       }
       return true;
    }

    private static boolean oneInsertAway(String s1, String s2) {

        int index1 = 0,index2 =0;
        while(index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1)!=s2.charAt(index2)){
                if(index1!=index2){
                    return false;
                }
                index2++;
            }
            else{
                index1++;
                index2++;
            }
        }
        return true;
    }
}