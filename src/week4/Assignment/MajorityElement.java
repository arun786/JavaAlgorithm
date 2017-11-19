package week4.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return 0;
        }
        if (left + 1 == right) {
            return a[left];
        }
        int number = countNumberinArray(a);
        return number;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getMajorityElement(a, 0, a.length));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static int countNumberinArray(int[] unsortedArray) {
        int[] sortedArray = merge_sort(unsortedArray);
        int half = (sortedArray.length) / 2;
        int initial = sortedArray[0];
        int count = 1;
        boolean check = false;
        for (int i = 1; i < sortedArray.length; i++) {
            if (initial == sortedArray[i]) {
                count++;

                if (i == sortedArray.length - 1 && count > half) {
                    check = true;
                }
            } else {
                initial = sortedArray[i];
                check = count > half ? true : false;
                count = 1;
            }

            if (check) {
                return 1;
            }
        }
        return 0;
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
}

