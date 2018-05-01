package LeetCode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

        MergeTwoSortedLists a = new MergeTwoSortedLists();

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(7);
        ListNode a5 = new ListNode(9);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(6);
        ListNode b4 = new ListNode(6);
        ListNode b5 = new ListNode(11);

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;

        ListNode temp = a.mergeTwoLists(a1,b1);

        System.out.println(temp.val);

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            if (list1 == null) return list2;
            if (list2 == null) return list1;

            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list2.next, list1);
                return list2;
            }
        }
    }

