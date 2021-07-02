package sorting;

public class MergeSort {
    private static int[] arr = {4, 5, 2, 8, 1};
    public static void main(String[] args) {
        mergeSort(0, arr.length-1);
        for (int val:
             arr) {
            System.out.println(val);
        }
    }

    private static void mergeSort(int l, int h) {
        if(l < h) {
            int mid = (l + h)/2;
            mergeSort(l, mid);
            mergeSort(mid + 1, h);
            merge(l, h, mid);
        }
    }

    private static void merge(int l, int r, int m) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        int i = 0, j = 0;


        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }
}
