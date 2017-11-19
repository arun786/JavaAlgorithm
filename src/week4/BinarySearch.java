package week4;

public class BinarySearch {

    public static void main(String[] args) {

        /*Binary search is for sorted algorithm which divides the whole array into 2 parts after each iteration*/
        int[] a = {3, 4, 7, 9, 10, 12, 35, 67, 67, 87, 90};
        int index = binarySearch(a, 0, 11, 90);
        System.out.println(index);

    }

    public static int binarySearch(int[] a, int low, int high, int key) {
        if (high < low) {
            return -1;
        }
        int mid = (high + low) / 2;
        if (key == a[mid]) {
            return mid;
        } else if (key < a[mid]) {
            return binarySearch(a, low, (mid - 1), key);
        } else if (key > a[mid]) {
            return binarySearch(a, (mid + 1), high, key);
        }
        return -1;
    }
}
