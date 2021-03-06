/**
 * Created by vigneshwarraghuram on 6/3/17.
 */

// Java Program to insert in a sorted list
public class LinkedListReversal
{
    Node head;  // head of list

    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    /* function to insert a new_node in a list. */
    void sortedInsert(Node new_node)
    {
        Node current;

         /* Special case for head node */
        if (head == null || head.data >= new_node.data)
        {
            new_node.next = head;
            head = new_node;
        }
        else {

            /* Locate the node before point of insertion. */
            current = head;

            while (current.next != null &&
                    current.next.data < new_node.data)
                current = current.next;

            new_node.next = current.next;
            current.next = new_node;
        }
    }

                  /*Utility functions*/

    /* Function to create a node */
    Node newNode(int data)
    {
        Node x = new Node(data);
        return x;
    }

    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    /* Drier function to test above methods */
    public static void main(String args[])
    {
        LinkedListReversal llist = new LinkedListReversal();
        Node new_node;
        new_node = llist.newNode(5);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(10);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(7);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(3);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(1);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(9);
        llist.sortedInsert(new_node);
        System.out.println("Created Linked List");
        llist.printList();

        //llist.reverse();
        llist.reverseUsingPrev();
        System.out.println('\n');
        llist.printList();
    }

    private void reverseUsingPrev() {

        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

    }

    private void reverse() {

        Node temp=head;
        int[] arr = new int[6];
        int i=0;
        while(temp!=null){
           arr[i]=temp.data;
           i++;
            temp = temp.next;
        }
        i = arr.length -1;
        head.data = arr[i];
        temp=head;
        while(temp!=null && i>=0){
            temp.data = arr[i];
            temp = temp.next;
            i--;
        }
    }
}