package queue;

public class QueueImp {
    public static void main(String[] args) {
        QueueMethods q = new QueueMethods(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.display();

        q.dequeue();

        q.display();
    }
}
