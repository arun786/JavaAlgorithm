package week4;

public class MergeSortAlgorithm {
    public static void main(String[] args) {
        int unsortedArray[] = new int[10];
        for(int i =0;i<10;i++){
            unsortedArray[i] = (int)(Math.random()*100);
        }

        printArray(unsortedArray);
        System.out.println();
        unsortedArray = merge_sort(unsortedArray);
        printArray(unsortedArray);
    }


    public static int[] merge_sort(int[] unsortedArray) {
        //step 1 : define the exit point
        if (unsortedArray.length <= 1) {
            return unsortedArray;
        }

        //step 2 define the midpoint
        int midpoint = unsortedArray.length / 2;

        //step 3 : initialize the left array and the right array
        int left[] = new int[midpoint];
        int right[];
        if (unsortedArray.length % 2 == 0) {
            right = new int[midpoint];
        } else {
            right = new int[midpoint + 1];
        }

        //step 4 : initialize the result
        int result[] = new int[unsortedArray.length];

        //step 5 : populate the left array
        for (int i = 0; i < midpoint; i++) {
            left[i] = unsortedArray[i];
        }

        //step 6 : populate the right array
        int x = 0;
        for (int j = midpoint; j < unsortedArray.length; j++) {
            right[x] = unsortedArray[j];
            x++;
        }

        //step 7 : call the left array and right array recursively
        left = merge_sort(left);
        right = merge_sort(right);

        result = merge(left, right);

        return result;
    }

    public static int[] merge(int[] left, int[] right) {

        int addIndex = left.length + right.length;
        int leftIndices = 0;
        int rightIndices = 0;
        int resultantIndices = 0;


        int[] result = new int[addIndex];

        while (leftIndices < left.length || rightIndices < right.length) {
            if (leftIndices < left.length && rightIndices < right.length) {
                if (left[leftIndices] <= right[rightIndices]) {
                    result[resultantIndices] = left[leftIndices];
                    resultantIndices++;
                    leftIndices++;
                } else if (left[leftIndices] >= right[rightIndices]) {
                    result[resultantIndices] = right[rightIndices];
                    resultantIndices++;
                    rightIndices++;
                }
            } else if (leftIndices < left.length) {
                result[resultantIndices] = left[leftIndices];
                resultantIndices++;
                leftIndices++;
            } else {
                result[resultantIndices] = right[rightIndices];
                resultantIndices++;
                rightIndices++;
            }
        }
        return result;
    }

    public static void printArray(int [] unsortedArray){
        for(int i=0;i<10;i++){
            System.out.print(unsortedArray[i] + " ");
        }
    }
}
