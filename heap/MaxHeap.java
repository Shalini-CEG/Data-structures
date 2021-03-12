import java.util.Scanner;

//MAX HEAP
public class MaxHeap
{

    int[] heapArr;
    int index, size;

    MaxHeap(int size)
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

        while( (heapArr[parent] < heapArr[child]) && parent > 0)
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
        maxHeapify(1);
        return del;
    }

    private void maxHeapify(int index)
    {
        if(isLeaf(index))
            return;

        if( (heapArr[index] < heapArr[leftChild(index)]) ||
                (heapArr[index] < heapArr[rightChild(index)]) )
        {
            if( heapArr[leftChild(index)] > heapArr[rightChild(index)]) {
                swap(index, leftChild(index));
                maxHeapify(leftChild(index));
            }
            else {
                swap(index, rightChild(index));
                maxHeapify(rightChild(index));
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
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        MaxHeap maxHeap = new MaxHeap(15);
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
                    maxHeap.insert(data);
                    System.out.println(data + " inserted\n");
                    System.out.println("After insertion: ");
                    maxHeap.print();
                    break;

                case 2:
                    maxHeap.print();
                    break;

                case 3:
                    int del = maxHeap.delete();
                    System.out.println(del + " deleted");
                    System.out.println("After Deletion: ");
                    maxHeap.print();
                    break;

                default:
                    System.out.println("\nInvalid Choice");
                    break;
            }
        }
        input.close();
    }

}

/*OUTPUT
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
1
Enter the data to be inserted: 50
50 inserted

After insertion:
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
1
Enter the data to be inserted: 67
67 inserted

After insertion:
PARENT : 67 LEFT CHILD : 50 RIGHT CHILD :0
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
2
PARENT : 67 LEFT CHILD : 50 RIGHT CHILD :0
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
1
Enter the data to be inserted: 20
20 inserted

After insertion:
PARENT : 67 LEFT CHILD : 50 RIGHT CHILD :20
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
1
Enter the data to be inserted: 77
77 inserted

After insertion:
PARENT : 77 LEFT CHILD : 67 RIGHT CHILD :20
PARENT : 67 LEFT CHILD : 50 RIGHT CHILD :0
1 - Insert
2 - Display
3  -Delete
4 - Exit
Enter your Choice:
3
77 deleted
After Deletion:
PARENT : 67 LEFT CHILD : 50 RIGHT CHILD :20
1 - Insert
2 - Display
3  -Delete
4 - Exit

* */
