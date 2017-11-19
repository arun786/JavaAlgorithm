package week4;

public class QuickSort {

    public static void main(String[] args) {

        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = (int) (Math.random() * 100);
        }

        printA(a);
        a = QuickSort(a, 0, 9);
        printA(a);

    }


    public static int[] QuickSort(int[] a, int start, int end) {
        if (start < end) {
            int pIndex = partition(a, start, end);
            QuickSort(a, start, pIndex - 1);
            QuickSort(a, pIndex + 1, end);
        }
        return a;
    }


    public static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int pIndex = start;

        for (int i = start; i <= end - 1; i++) {
            if (a[i] <= pivot) {
                a = swap(a, i, pIndex);
                pIndex++;
            }
        }

        swap(a, pIndex, end);
        return pIndex;
    }

    private static int[] swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }

    private static void printA(int[] a) {
        for (int as : a) {
            System.out.print(as + " ");
        }
        System.out.println();
    }
}
