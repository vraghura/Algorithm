package LeetCode.LinkedLIst;

import LeetCode.Utilities.ListNode;

import java.util.Stack;

public class Palindrome {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
       listNode.next = (new ListNode(1));
       listNode.next.next = (new ListNode(2));
        listNode.next.next.next = (new ListNode(1));
        listNode.next.next.next.next = (new ListNode(0));

        System.out.println("Palindrome="+isPalindrome(listNode));
    }

    private static boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        ListNode fast, slow;
        fast= head;
        slow=head;

        while(fast!=null && fast.next!=null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast!=null){
            slow = slow.next;
        }

        while(slow!=null){
            int val = stack.pop();
            if(val!=slow.data){
               return false;
            }
            slow = slow.next;
        }

        return true;
    }
}
