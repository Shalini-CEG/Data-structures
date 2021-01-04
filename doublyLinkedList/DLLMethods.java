package doublyLinkedList;

import linkedList.LMethods;

public class DLLMethods {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            next = null;
            prev = null;
        }
    }
    Node head;

    public void insertRec(int data){
        if(head == null){
            Node newNode = new Node(data);
            head = newNode;
            System.out.println("New node created;");
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node node = new Node(data);
        node.prev = temp;
        temp.next = node;

        System.out.println(node.data + " is inserted!");
    }

    public void deleteRec(int pos){

        if(pos ==  1 && head.next != null){
            System.out.println(head.data + " is deleted..");
            head.next.prev = null;
            head = head.next;
            return;
        }
        Node temp = head;
        while(temp != null && pos > 1){
            temp = temp.next;
            pos--;
        }

        if(temp == null){
            System.out.println("Element not found");
            return;
        }
        if(temp.next != null){
            temp.prev.next = temp.next;
        }
        temp.next.prev = temp.prev;



    }

    public void display(){
        Node temp = head;

        if(temp == null)
            System.out.println("List is empty!");

        while(temp != null && temp.next != null){
            System.out.println(""+ temp.data);
            temp = temp.next;
        }
        System.out.println(""+ temp.data);
    }
}
