package week4;

import java.util.Arrays;

public class LinearSearch {

    public static void main(String[] args) {

        /*Linear Search is for unsorted array where the required element is searched
        from 0th index and traversing up till the element is found*/
        String[] words = {"Arun", "Adwiti", "Sachin", "Pushpa", "Dravid"};
        long start = System.currentTimeMillis();
        Integer index = linearSearch(words, 0, 4, "Pushpa");
        long end = System.currentTimeMillis();
        System.out.println("time taken to find the index is " + (end - start) + " : " + index);

    }

    public static Integer linearSearch(String[] words, int low, int high, String key) {
        if (low > high) {
            return 0;
        } else if (words[low] == key) {
            return low;
        }
        return linearSearch(words, low + 1, high, key);
    }
}
