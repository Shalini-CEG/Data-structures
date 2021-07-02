package sorting;

public class QuickSort {
    private static int[] arr = {4, 5, 2, 8, 1};

    public static void main(String[] args) {
        int l = 0, h = arr.length-1;
        quickSort(l, h);

        for (int val:
             arr) {
            System.out.println(val);
        }
    }

    private static void quickSort(int l, int h) {
        if(l < h){
            int pi = partition(l, h);
            quickSort(l, pi-1);
            quickSort(pi+1, h);
        }
    }

    private static int partition(int l, int h) {
        int i=l, j=h;
        int pivot = arr[l];

        while(i < j){
            while(pivot >= arr[i] && i < h) i++;
            while(pivot < arr[j] && j > l) j--;

            if(i < j) swap(i, j);
        }

        swap(l, j);

        return j;
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
