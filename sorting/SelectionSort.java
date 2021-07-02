package sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {4, 5, 2, 8, 1};
        sort(arr, arr.length);
    }

    private static void sort(int[] arr, int n) {

        for (int i = 0; i < n-1; i++) {
            int min = i;

            for (int j = i+1; j < n; j++) {
                if(arr[min] > arr[j]) min = j;
            }

            if(min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }

        for (int i:
             arr ) {
            System.out.println(i);
        }
    }
}
