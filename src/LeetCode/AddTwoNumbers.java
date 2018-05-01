package LeetCode;

import LeetCode.Utilities.ListNode;

/**
 * Created by vigneshwarraghuram on 10/28/17.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();

        l1.data = 2;
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        l2.data = 5;
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.data : 0;
            int y = (l2 != null) ? l2.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        System.out.println(dummyHead.next.data);
    }
}