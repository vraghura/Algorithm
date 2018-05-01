package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class LetterCombPhNum {

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };


    public static void main(String[] args) {

       // System.out.println(letterCombinations("23"));
       // System.out.println(letterCombinations1("23"));
        System.out.println(letterCombinations2("23"));
    }


    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> result = new ArrayList<>();
        StringBuffer s = new StringBuffer();
        DFS(digits, result, s, 0, map);
        return result;
    }

    public static void DFS(String digits, List<String> result, StringBuffer s, int start,
                           HashMap<Integer, String> map) {
        if (start == digits.length())
            result.add(s.toString());
        else {
            String tmp = map.get(digits.charAt(start) - '0');
            for (int i = 0; i < tmp.length(); i++) {
                s.append(tmp.charAt(i));
                DFS(digits, result, s, start + 1, map);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }


    public static List<String> letterCombinations1(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : map.get(x).toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }


    public static List<String> letterCombinations2(String digits) {
        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, ret);
        return ret;
    }

    private static void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }
}
