/**
 * Created by vigneshwar raghuram on 6/3/17.
 */
public class LinkList {

    Node head;

    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    //Method to Insert the Linked List
    private void insert(Node newNode) {

        Node current;
          /* Special case for head node */
        if (head == null)
        {
            head = newNode;
        }
        else {
            current = head;
            while (current.next!=null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    Node newNode(int data)
    {
        Node x = new LinkList.Node(data);
        return x;
    }


    public static void main(String[] args) {
        LinkList llist = new LinkList();
        Node newNode;
        newNode = llist.newNode(5);
        llist.insert(newNode);
        newNode = llist.newNode(6);
        llist.insert(newNode);
        newNode = llist.newNode(7);
        llist.insert(newNode);
        newNode = llist.newNode(1);
        llist.insert(newNode);
        //printLinkedList(llist);

        llist.deleteNode(7);
        printLinkedList(llist);

    }

    private void deleteNode(int i) {
        Node temp = head.next;
        Node prev = head;

        //Deleting a head node
        if(i==head.data){
        prev = head.next;
        head = prev;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != i)
        {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }


    private static void printLinkedList(LinkList llist) {

        Node temp = llist.head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}