package stack;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String s = "{{[[(())]]}}";

        Stack<Character> stack = new Stack<>();

        if(s.isEmpty()){
            System.out.println("Balanced..");
        }

        for(int i=0; i<s.length(); i++){

            char current = s.charAt(i);
            if(current == '{' || current == '(' || current == '['){
                stack.push(current);
            }
            char top = stack.peek();
            if(current == '}' || current == ']' || current == ')'){
                if(stack.isEmpty()){
                    System.out.println("Not balanced");
                }
                if((top == '{' && current == '}') || (top == '(' && current == ')') || (top == '[' && current == ']')){
                    stack.pop();
                }
                else {
                    System.out.println("Not balanced");
                }
            }

        }
        if(stack.isEmpty())
            System.out.println("Balanced")  ;
        else
            System.out.println("NOt Balanced");
    }
}
