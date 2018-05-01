package LeetCode;

import java.util.Stack;

public class ValidParantheses {


    public static void main(String[] args) {

        System.out.println(isValid("()[]{}"));

    }


    public static boolean isValid(String input) {

        char[] ch = input.toCharArray();

        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            switch (ch[i]) {
                case '(':
                   characterStack.push(')');
                    break;
                case '[':
                    characterStack.push(']');
                    break;
                case '{':
                    characterStack.push('}');
                    break;
                default:
                    if(characterStack.isEmpty() || characterStack.pop() != ch[i])
                    return false;
            }
        }
        return characterStack.isEmpty();

    }
}
