// Min-Heap Implementation
import java.util.Scanner;

class MinHeap
{
    int[] heapArr;
    int index, size;

    MinHeap(int size)
    {
        this.size = size;
        this.index = 0;
        heapArr = new int[this.size];
    }

    private int getParent(int index)
    {
        return (index / 2);
    }

    private int leftChild(int index)
    {
        return (2 * index);
    }

    private int rightChild(int index)
    {
        return (2 * index) + 1;
    }

    private boolean isLeaf(int index)
    {
        if(index >= size/2 && index <= size)
            return true;

        return false;
    }

    private void swap(int index1, int index2)
    {
        int temp;
        temp = heapArr[index1];
        heapArr[index1] = heapArr[index2];
        heapArr[index2] = temp;
    }

    public void insert(int data)
    {
        heapArr[++index] = data;

        int child = index;
        int parent = getParent(child);

        while( (heapArr[parent] > heapArr[child]) && parent > 0)
        {
            swap(parent, child);
            child = parent;
            parent = getParent(child);;
        }
    }

    public int delete()
    {
        int del = heapArr[1];
        heapArr[1] = heapArr[index--];
        minHeapify(1);
        return del;
    }

    private void minHeapify(int index)
    {
        if(isLeaf(index))
            return;

        if( (heapArr[index] > heapArr[leftChild(index)]) ||
                (heapArr[index] > heapArr[rightChild(index)]) )
        {
            if( heapArr[leftChild(index)] < heapArr[rightChild(index)]) {
                swap(index, leftChild(index));
                minHeapify(leftChild(index));
            }
            else {
                swap(index, rightChild(index));
                minHeapify(rightChild(index));
            }
        }
    }

    public void print()
    {
        for (int i = 1; i <= index / 2; i++) {
            System.out.print("PARENT : " + heapArr[i] +
                    " LEFT CHILD : " + heapArr[leftChild(i)] +
                    " RIGHT CHILD :" + heapArr[rightChild(i)]);

            System.out.println();
        }
    }
}

public class Heap
{
    public static void main(String args[])
    {
        MinHeap obj = new MinHeap(10);

        Scanner input = new Scanner(System.in);

        boolean op = true;
        while(op)
        {
            System.out.println("1 - Insert\n2 - Display\n3  -Delete\n4 - Exit");
            System.out.print("Enter your Choice: \n");
            int choice = input.nextInt();
            int data;

            switch(choice)
            {
                case 1:
                    System.out.print("Enter the data to be inserted: ");
                    data = input.nextInt();
                    obj.insert(data);
                    System.out.println(data + " inserted\n");
                    break;

                case 2:
                    obj.print();
                    break;

                case 3:
                    int del = obj.delete();
                    System.out.println(del + " deleted");
                    break;


                default:
                    System.out.println("\nInvalid Choice");
                    op = false;
                    break;
            }
        }
        input.close();
    }
}

/* Ouptut

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
1
Enter the data to be inserted: 60
60 inserted

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
1
Enter the data to be inserted: 30
30 inserted

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
1
Enter the data to be inserted: 40
40 inserted

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
1
Enter the data to be inserted: 11
11 inserted

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
1
Enter the data to be inserted: 33
33 inserted

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
1
Enter the data to be inserted: 100
100 inserted

1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
2
PARENT : 11 LEFT CHILD : 30 RIGHT CHILD :40
PARENT : 30 LEFT CHILD : 60 RIGHT CHILD :33
PARENT : 40 LEFT CHILD : 100 RIGHT CHILD :0
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
3
11 deleted
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
2
PARENT : 30 LEFT CHILD : 33 RIGHT CHILD :40
PARENT : 33 LEFT CHILD : 60 RIGHT CHILD :100
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
4

Invalid Choice


*/
