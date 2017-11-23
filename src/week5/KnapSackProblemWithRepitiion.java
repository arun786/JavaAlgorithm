package week5;

public class KnapSackProblemWithRepitiion {

    //problem statement is we cannot take part of the weight, it should be whole and can be repetitive
    public static void main(String[] args) {
        int[] weights = new int[]{2, 3, 4, 6};
        int[] values = new int[]{9, 14, 16, 30};
        System.out.println(withRepetition(weights, values, 10));
    }


    public static int withRepetition(int[] w, int[] v, int maxWeight) {
        int maxValue;
        int[] result = new int[maxWeight + 1];
        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < w.length; j++) {
                if (w[j] > i) {
                    continue;
                }
                int candidate = result[i - w[j]] + v[j];
                if (candidate > result[i]) {
                    result[i] = candidate;
                }
            }
        }

        maxValue = result[result.length - 1];


        return maxValue;
    }

}
