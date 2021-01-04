package linkedList;

import java.util.HashMap;
import java.util.Map;

public class LMethods{
    class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    public void add(int data){
        Node toAdd = new Node(data);

        if(head == null){
            head = toAdd;
            return;
        }
        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = toAdd;
    }

    public void delete(int pos){

        Node temp = head;
        int count = 1;


        while(count < pos-1){
            temp = temp.next;
            count++;

        }

        Node current = temp.next;
        temp.next = current.next ;
        current.next = null;

        System.out.println("Deleted elt at position "+ pos);

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

    public void findNthElt(int n){
        Node slow = head;
        Node fast = head;
        int count = 0;

        while(count < n){
            fast = fast.next;
            count += 1;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println(slow.data);
    }

    public void addOne(){
        Node res = head;
        Node temp = null;
        int sum;
        int carry = 1;

        while(head != null){
            sum = 1 + head.data;
            carry = (sum >= 10)? 1 : 0;
            sum = sum % 10;
            head.data = sum;
            temp = head;
            head = head.next;
        }

        if(carry > 0){
            temp.next = new Node(carry);
        }
        head = res;
        reverseList();
        displayList();

    }

    public void findMidElement(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element is " + slow.data);
    }

    public void reverseList(){
        Node prev = null;
        Node next;
        Node current = head;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;

        System.out.println("List reversed successfully with new head " + prev.data);
    }



    public void search(int data){
        Node temp = head;

        while(temp.next !=null){
            if(temp.data == data){
                System.out.println("Found element "+ temp.data);
            }
            temp = temp.next;
        }
    }

    public void isPalindrome(){
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        boolean flag = false;
        int nextOccurence;

      Node temp = head;

        while(temp != null){
            count += 1;
            System.out.println("count == " + count);
            if(!map.containsKey(count)){
                map.put(count, temp.data);
            }
            temp = temp.next;
        }

        for(int i: map.keySet()){

//            System.out.println("key: " + i);

            nextOccurence = 1 + count - i;

            if(map.get(i) == map.get(nextOccurence)){
                System.out.println(map.get(i) + "==" + map.get(nextOccurence));
                flag = true;
            }
            else {
                flag = false;
                break;
            }

        }
        System.out.println("Is Palindrome : " + flag);
    }
}