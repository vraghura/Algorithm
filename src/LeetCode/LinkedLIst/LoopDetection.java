package LeetCode.LinkedLIst;

import LeetCode.Utilities.ListNode;

public class LoopDetection {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(3);
        l1.next = (new ListNode(1));
        l1.next.next = (new ListNode(5));
        l1.next.next.next = (new ListNode(9));
        l1.next.next.next.next = (new ListNode(7));
        l1.next.next.next.next.next = (new ListNode(2));
        l1.next.next.next.next.next.next = l1.next.next;

        ListNode start = loopDetect(l1);
        System.out.println(start.data);
    }

    private static ListNode loopDetect(ListNode head) {
        ListNode fast, slow;
        fast =head;
        slow = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        slow =head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}