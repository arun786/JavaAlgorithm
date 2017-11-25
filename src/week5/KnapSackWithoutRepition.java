package week5;

import java.util.Scanner;

public class KnapSackWithoutRepition {


    public static void main(String[] args) {

        System.out.println("Enter the size of the array..");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        int v[] = new int[size];
        int w[] = new int[size];

        System.out.println("Enter the weight and their corresponding value");
        System.out.println("W    Value");
        for (int i = 0; i < size; i++) {
            w[i] = scan.nextInt();
            v[i] = scan.nextInt();
            System.out.println();
        }


        System.out.println("Enter the maximum weight ");
        int maxWeight = scan.nextInt();
        int maxValue = getKnapSackValue(w, v, maxWeight);
        System.out.println(maxValue);

    }

    public static int getKnapSackValue(int[] w, int[] v, int maxWeight) {
        int[][] result = new int[w.length + 1][maxWeight + 1];

        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[1].length; j++) {
                result[i][j] = result[i - 1][j];
                if (w[i - 1] <= j) {
                    int candidate = result[i - 1][j - w[i - 1]] + v[i - 1];
                    if (candidate > result[i][j]) {
                        result[i][j] = candidate;
                    }
                }
            }
        }

        return result[v.length][maxWeight];
    }
}
