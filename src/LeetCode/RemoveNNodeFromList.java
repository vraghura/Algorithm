package LeetCode;

public class RemoveNNodeFromList {


    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

      //  System.out.println(removeNthFromEnd(a1, 2));
        System.out.println(removeNthFromEnd1(a1, 2));

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode dummy = new ListNode(0);

        ListNode first;
        ListNode second;

       first =dummy;
       second =dummy;

       second.next = head;

        for(int i=1; i<=n+1; i++){
            first = first.next;
        }

        while(first!=null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }
}