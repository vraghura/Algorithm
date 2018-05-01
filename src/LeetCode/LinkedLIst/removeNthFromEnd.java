package LeetCode.LinkedLIst;

import LeetCode.Utilities.ListNode;

public class removeNthFromEnd {


    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
       // listNode.next = (new ListNode(2));
/*        listNode.next.next = (new ListNode(3));
        listNode.next.next.next = (new ListNode(4));
        listNode.next.next.next.next = (new ListNode(5));*/
        ListNode temp = removeNthFromEnd(listNode,1);
        System.out.println(temp.data);

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next==null){
            return null;
        }
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=0; i<=n; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}