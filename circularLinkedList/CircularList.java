package circularLinkedList;

public class CircularList {
    public static void main(String[] args) {
        CircularListMethods cll = new CircularListMethods();
        cll.circularList();
        int len = cll.returnLength();

        System.out.println(len + " length");

//      cll.displayList();
        cll.deleteRec(3);
        cll.search(33);
    }
}
