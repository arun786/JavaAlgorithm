package week4;

public class SelectionSortAlgorithm {
    public static void main(String[] args) {

        int unsortedArray[] = {2,5,3,10,0,45,23};
        int sortedArray[] = SelectionSort(unsortedArray);
        for(int a :sortedArray)
        System.out.println(a);
    }

    public static int[] SelectionSort(int[] unsortedArray) {

        for (int i = 0; i < unsortedArray.length; i++) {
            for (int j = i+1 ; j < unsortedArray.length; j++) {
                if (unsortedArray[j] < unsortedArray[i]) {
                    unsortedArray = swap(unsortedArray, j, i);
                }
            }
        }
        return unsortedArray;
    }

    private static int[] swap(int[] unsortedArray, int i, int j) {
        int temp = unsortedArray[i];
        unsortedArray[i] = unsortedArray[j];
        unsortedArray[j] = temp;
        return unsortedArray;
    }


}
