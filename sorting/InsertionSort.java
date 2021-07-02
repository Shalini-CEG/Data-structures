package sorting;

public class InsertionSort {
    static void insert(int arr[],int i)
    {
//        int temp = arr[i];
//        int j = i - 1;
//
//        while((j >= 0) && arr[j+1] > temp){
//            arr[j+1] = arr[j];
//            j--;
//        }
//
//        arr[j+1] = temp;
    }

    //Function to sort the array using insertion sort algorithm.
    public static void insertionSort(int arr[], int n) {
        for (int i = 1; i < n; i++) {
//            insert(arr, i);
            int temp = arr[i];
            int j = i - 1;

            while((j >= 0) && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 8, 5, 7, 4};
        int n = arr.length;
        insertionSort(arr, n);

        for (int i:
             arr) {
            System.out.println(i);
        }
    }
}
