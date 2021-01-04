package circularLinkedList;

import linkedList.LMethods;

public class CircularListMethods {
    private Node last;
    int length;
    Node head;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public CircularListMethods() {
        length = 0;
        last = null;
        head = null;
     }

    public int returnLength(){
        return length;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public void displayList(){
        Node temp = head;

        if(temp == null)
            System.out.println("List is empty!");

        while(temp != null){
            System.out.println(""+ temp.data);
            temp = temp.next;
        }
    }

    public void circularList(){
        if(head == null){
            Node first = new Node(3);
            head = first;
            length += 1;
        }

        Node second = new Node(30);
        Node third = new Node(33);
        Node fourth = new Node(35);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = head;

        last = fourth;
    }

    public void deleteRec(int data){
        if(data == head.data ){
            System.out.println("Deleted successfully ");
            head = head.next;
            return ;
        }
    }

    public void search(int data){
        if(data == head.data || data == last.data){
            System.out.println("Found data "+ data);
            return ;
        }
        Node temp = head.next;
       while(temp.data != last.data){
               if(temp.data == data){
                   System.out.println("Data found" + data);
                   return;
               }
               temp = temp.next;
       }

    }
}
