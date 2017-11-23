package week5;

import java.util.Scanner;

public class KnapSackProblemUsingGreedyAlgorithm {
    public static void main(String[] args) {
        System.out.println("Enter the size of the array..");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        double v[] = new double[size];
        double w[] = new double[size];

        System.out.println("Enter the weight and their corresponding value");
        System.out.println("W    Value");
        for (int i = 0; i < size; i++) {
            w[i] = scan.nextInt();
            v[i] = scan.nextInt();
            System.out.println();
        }


        System.out.println("Enter the maximum weight ");
        double maxWeight = scan.nextDouble();
        double valueByWeight[] = new double[size];
        for (int i = 0; i < v.length; i++) {
            valueByWeight[i] = v[i] / w[i];
        }

        sort(valueByWeight, 0, valueByWeight.length - 1, v, w);

        for (int i = 0; i < valueByWeight.length; i++) {
            System.out.print(valueByWeight[i] + " ");
        }

        double maxValue = knapsackproblem(v, w, valueByWeight, maxWeight);
        System.out.println(maxValue);
    }

    private static double knapsackproblem(double[] value, double[] weight, double[] fraction, double maxWeight) {

        //step 1 : iterate through the fraction
        //step 2 : check the fraction, with the weight and the max weight
        //step 3 : if the weight is less than the max weight, add to the bag and reduce the max weight
        //step 4: if the weight is more than the max weight,  then break

        double maxValue = 0;
        for (int i = 0; i < fraction.length; i++) {
            if (weight[i] <= maxWeight) {

                maxValue = maxValue + value[i];
                maxWeight = maxWeight - weight[i];
            } else if (maxWeight != 0) {
                maxValue = maxValue + (value[i] / weight[i]) * maxWeight;
                maxWeight = 0;
            }
        }
        return maxValue;
    }

    private static void sort(double[] a, int l, int r, double[] v, double[] w) {
        if (r < l) {
            return;
        }
        int m = partition(a, l, r, v, w);
        sort(a, l, m - 1, v, w);
        sort(a, m + 1, r, v, w);
    }

    private static int partition(double[] a, int l, int r, double[] v, double[] w) {

        double pivot = a[l];
        int pointer = l;

        for (int i = l + 1; i <= r; i++) {
            if (a[i] >= pivot) {
                pointer++;
                double temp = a[i];
                a[i] = a[pointer];
                a[pointer] = temp;

                temp = v[i];
                v[i] = v[pointer];
                v[pointer] = temp;

                temp = w[i];
                w[i] = w[pointer];
                w[pointer] = temp;
            }
        }

        double t = a[l];
        a[l] = a[pointer];
        a[pointer] = t;

        t = v[l];
        v[l] = v[pointer];
        v[pointer] = t;

        t = w[l];
        w[l] = w[pointer];
        w[pointer] = t;

        return pointer;
    }
}
