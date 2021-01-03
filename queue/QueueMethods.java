package queue;

public class QueueMethods {
    private int front, rear ;
    private int capacity;
    private int q[];

    QueueMethods(int size){
        front = rear = 0;
        capacity = size;
        q = new int[capacity];
    }

    public void enqueue(int data){
        if(capacity == rear)
            System.out.println("Queue is full..");
        else{
            q[rear] = data;
            rear++;
        }
        System.out.println(data + " has been added.");
    }

    public void dequeue(){
        if(front == rear)
            System.out.println("Queue is empty");
        else{
            for (int i = 0; i < rear - 1; i++) {
                q[i] = q[i+1];
            }
            rear--;
        }
        System.out.println("Element is removed..");
    }

    public void display(){
        System.out.println("Queue: ");
        for (int i = front; i < rear  ; i++) {
            System.out.println(q[i]);
        }
    }
}
