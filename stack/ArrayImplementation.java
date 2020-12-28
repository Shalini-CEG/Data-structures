package stack;

public class ArrayImplementation{
    int size;
    Integer top;
    int arr[];

    ArrayImplementation(int len){
        size = len;
        arr = new int[size];
        top = -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public void push(int data) throws Exception{
        if(isFull()){
            throw new Exception(" Your stack is full..");
        }
        else{
            top += 1;
            arr[top] = data;
            System.out.println( arr[top] + " added successfully!");
        }
    }

    public void pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Your stack is empty");
        }
        else{
            System.out.println(arr[top] + " is deleted.");
            top -= 1;
        }
    }

    public void peek() throws Exception{
        if(top < 0)
            throw new Exception("Nothing is there to peek");
        else{
            System.out.println("The top element is "+ arr[top]);
        }
    }

}
