package queue;

import java.util.Stack;

public class QUsingStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int data){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(data);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        System.out.println(data + " has been added.");
    }

    public void dequeue(){
        if(stack1.isEmpty()){
            System.out.println("Queue is empty..");
        }

        int x = stack1.peek();
        stack1.pop();

        System.out.println(x + " has been removed.");
    }

    public void display(){
        System.out.println(stack1);
    }
}
