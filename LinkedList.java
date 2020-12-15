package LinkedList;

class LMethods{
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
}

public class LinkedList {
    public static void main(String[] args) {
        LMethods fun = new LMethods();

        fun.add(20);
        fun.add(50);
        fun.add(60);
        fun.add(70);
        fun.add(88);


        fun.displayList();

        fun.delete(3);

        fun.displayList();

        fun.search(70);
        fun.search(20);

        fun.reverseList();
        fun.displayList();
    }
}
