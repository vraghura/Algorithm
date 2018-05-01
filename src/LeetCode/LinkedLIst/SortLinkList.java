package LeetCode.LinkedLIst;

import LeetCode.Utilities.ListNode;

public class SortLinkList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = (new ListNode(4));
        listNode.next.next = (new ListNode(1));
        listNode.next.next.next = (new ListNode(5));
        listNode.next.next.next.next = (new ListNode(2));
        listNode.next.next.next.next.next = (new ListNode(7));
        ListNode temp = sortList(listNode);
        System.out.println(temp.data);
    }

    private static ListNode sortList(ListNode head) {
       if(head==null || head.next==null){
           return head;
       }
       ListNode fast = head;
       ListNode slow = head;

       ListNode prev =null;
       while(fast!=null && fast.next!=null){
           prev = slow;
           fast = fast.next.next;
           slow = slow.next;
       }

       prev.next=null;

       ListNode l1 = sortList(head);
       ListNode l2 = sortList(slow);

       return mergeSort(l1,l2);
    }

    private static ListNode mergeSort(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode(0);
        ListNode temp = l3;

        while(l1!=null && l2!=null) {
            if (l1.data < l2.data) {
                temp.next=l1;
                l1 = l1.next;
            } else {
                temp.next=l2;
                l2 = l2.next;
            }
            temp=temp.next;
        }

        if (l1 != null)
            temp.next = l1;

        if (l2 != null)
            temp.next = l2;

        return l3.next;
    }
}