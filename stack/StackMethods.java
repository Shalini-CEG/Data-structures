package stack;

public class StackMethods {
    public static void main(String[] args) throws Exception {

        ArrayImplementation sm = new ArrayImplementation(5);
        sm.push(200);
        sm.push(300);
        sm.push(400);
        sm.peek();
        sm.pop();
        sm.peek();
        System.out.println();

        LinkedListImplementation<Integer> lm = new LinkedListImplementation<>();
        lm.push(90);
        lm.push(1000);
        lm.push(50);
        lm.peek();
        lm.pop();
        lm.peek();

    }
}
