package queue;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedListImp {
    Node front, rear;
    LinkedListImp(){
        this.front = this.rear = null;
    }

    public void enqueue(int data){
        Node newNode = new Node(data);
        if(rear == null)
            front = rear = newNode;
        else{
            rear.next = newNode ;
            rear = newNode;
        }
        System.out.println(data + " added on queue.");
    }

    public void dequeue(){
        if(front == null) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = this.front;
        front = front.next;
        if(front == null)
            rear = null;
    }

    public void display(){
        System.out.println("Queue");
        Node temp = front;
        while(temp != null ){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
