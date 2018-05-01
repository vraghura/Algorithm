package LeetCode.LinkedLIst;

import LeetCode.Utilities.ListNode;

import java.util.Stack;

public class AddTwoNumbers2 {


    public static void main(String[] args) {

        ListNode listNode = new ListNode(7);
        listNode.next = (new ListNode(2));
        listNode.next.next = (new ListNode(4));
        listNode.next.next.next = (new ListNode(3));


        ListNode listNode1 = new ListNode(5);
        listNode1.next = (new ListNode(6));
        listNode1.next.next = (new ListNode(4));

        ListNode temp = addTwoNumbers(listNode, listNode1);
        System.out.println(temp.data);

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();


        ListNode l3;


        while (l1 != null) {
            stack1.push(l1.data);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.data);
            l2 = l2.next;
        }

        int carry=0;
        ListNode list = new ListNode(0);
        while(!stack1.empty() || !stack2.empty()){
            int x = !stack1.isEmpty()? stack1.pop() : 0;
            int y = !stack2.isEmpty()? stack2.pop() : 0;
            int sum = x+y+carry;
            carry =sum/10;
            l3 = new ListNode(sum%10);
            l3.next = list;
            list=l3;
        }

        return list.next;
    }
}