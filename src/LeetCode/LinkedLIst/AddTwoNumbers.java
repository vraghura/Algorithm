package LeetCode.LinkedLIst;

import LeetCode.Utilities.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(2);
        listNode.next = (new ListNode(4));
        listNode.next.next = (new ListNode(3));


        ListNode listNode1 = new ListNode(5);
        listNode1.next = (new ListNode(6));
        listNode1.next.next = (new ListNode(4));

        ListNode temp = addTwoNumbers(listNode,listNode1);
        System.out.println(temp.data);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;
        while (l1!=null && l2!=null){
            int x = l1.data;
            int y = l2.data;
            int sum = carry + x + y;
            carry = sum / 10;
            l3.next = new ListNode(sum % 10);
            l1=l1.next;
            l2=l2.next;
            l3=l3.next;
        }
        return dummy.next;
    }
}