package doublyLinkedList;

public class Dll {
    public static void main(String[] args) {
        DLLMethods obj = new DLLMethods();

        obj.insertRec(90);
        obj.insertRec(60);
        obj.insertRec(40);
        obj.deleteRec(2);

        obj.display();
    }
}
