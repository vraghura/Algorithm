package LeetCode.LinkedLIst;

import LeetCode.Utilities.ListNode;

public class Intersection {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(3);
        l1.next = (new ListNode(1));
        l1.next.next = (new ListNode(5));
        l1.next.next.next = (new ListNode(9));
        l1.next.next.next.next = (new ListNode(7));
        l1.next.next.next.next.next = (new ListNode(2));
        l1.next.next.next.next.next.next = (new ListNode(1));


        ListNode l2 = new ListNode(4);
        l2.next = (new ListNode(6));
        l2.next.next = l1.next.next.next.next;
        l2.next.next.next = l1.next.next.next.next.next;
        l2.next.next.next.next =  l1.next.next.next.next.next.next;
        ListNode temp = getIntersectionNode(l2,l1);
        System.out.println(temp.data);
    }


    /*
    1, Get the length of the two lists.

2, Align them to the same start point.

3, Move them together until finding the intersection point, or the end null
     */

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}
