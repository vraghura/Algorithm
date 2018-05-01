package LeetCode.LinkedLIst;

import java.util.HashSet;

public class LinkedLIstQns {


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
       // linkedList.insert(2);
        printLinkedList(linkedList.head);

        //removeDuplicate(linkedList);
       // printLinkedList(linkedList);
/*        Index idx = new Index();
        Node test = KthToLast(linkedList.head,3,idx);*/

        //printLinkedList(linkedList.head);

       // Node temp = partionList(linkedList.head, 3);
       // printLinkedList(temp);

        Node temp = rotateListByK(linkedList.head, 2);
        printLinkedList(temp);
    }

    private static Node rotateListByK(Node head, int k) {

        if(head==null)
            return null;
        int size = 1; // since we are already at head node
        Node fast = head;
        Node slow = head;

        while(fast.next!=null){
            size++;
            fast = fast.next;
        }

        for(int i= size-k%size; i>1; i--) // i>1 because we need to put slow.next at the start.
            slow = slow.next;

        // No dummy variable.
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }

    private static Node partionList(Node head, int x) {
        Node dummy1 = new Node(0), dummy2 = new Node(0);  //dummy heads of the 1st and 2nd queues
        Node curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
        while (head!=null){
            if (head.data<x) {
              curr1.next = head;
              curr1 = head;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
    }

    private static Node KthToLast(Node head, int k, Index idx) {
        if(head==null){
            return null;
        }
        Node node = KthToLast(head.next,k,idx);
        idx.value+=1;
        if(idx.value==k){
            return head;
        }
        return node;
    }

    private static void removeDuplicate(LinkedList list) {
        HashSet<Integer> hashSet = new HashSet<>();
        Node temp = list.head;
        Node prev = null;
        while(temp!=null){
            if(hashSet.contains(temp.data)){
                prev.next = temp.next;
            }
            else{
                hashSet.add(temp.data);
                prev = temp;
            }
            temp = temp.next;
        }
    }

    private static void printLinkedList(Node head) {
        System.out.println("");
        while(head!=null){
            System.out.print("\t"+head.data);
            head = head.next;
        }
    }
}

class Index{
    public int value=0;
}