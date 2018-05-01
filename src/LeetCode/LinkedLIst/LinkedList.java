package LeetCode.LinkedLIst;

public class LinkedList {

   Node head;

   public LinkedList(){
       head = null;
   }

    public void insert(int data) {
        Node link = new Node(data);
        if(head==null){
            head = link;
            return;
        }
        else{
            Node n = head;
            while(n.next!=null){
                n = n.next;
            }
            n.next = link;
        }

   }
}