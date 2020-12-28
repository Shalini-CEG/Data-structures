package stack;

public class LinkedListImplementation<T> {
    class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
        }
    }
    Node head;

    public boolean isEmpty(){
        return head==null;
    }

    public void push(T data){
        Node<T> toAdd = new Node<>(data);

        if(head == null){
            head = toAdd;
            System.out.println(toAdd.data + " added! " );
            return;
        }
        
        Node<T> temp = head;
        
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = toAdd;
        System.out.println(toAdd.data + " added! ");
    }

    public void pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }
        else{
            Node<T> temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            System.out.println("Popped element: " + temp.next.data);
            temp.next = null;

        }
    }

    public void peek(){
        Node<T> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        System.out.println("The top element is " + temp.data);
    }
}
