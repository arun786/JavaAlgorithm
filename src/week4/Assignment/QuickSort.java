package week4.Assignment;

import java.util.Scanner;

public class QuickSort {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = scan.nextInt();
        }
        quickSort(a, 0, size - 1);
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }

    }


    public static void quickSort(int[] a, int lt, int rt) {

        if (lt >= rt) {
            return;
        }
        int m = partition(a, lt, rt);
        quickSort(a, lt, m - 1);
        quickSort(a, m + 1, rt);
    }

    private static int partition(int[] a, int lt, int rt) {

        int k = a[lt];    //pivotal
        int pointer = lt; //pointer which will swap the values.

        for (int i = lt + 1; i <= rt; i++) {
            if (a[i] <= k) {
                pointer++;
                int temp = a[i];
                a[i] = a[pointer];
                a[pointer] = temp;
            }
        }
        int t = a[lt];
        a[lt] = a[pointer];
        a[pointer] = t;
        return pointer;
    }


}
