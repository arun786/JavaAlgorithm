package week4;

public class MultiPolynomialNaiveWay {
    public static void main(String[] args) {
        Integer[] A = {3, 2, 5};
        Integer[] B = {5, 1, 2};
        Integer[] result = getCoeficientOfProductOftwoPolynomials(A, B, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }


    public static Integer[] getCoeficientOfProductOftwoPolynomials(Integer[] A, Integer[] B, int n) {
        Integer[] result = new Integer[2 * n - 1];
        for (int i = 0; i < 2 * n - 1; i++) {
            result[i] = 0;
        }

        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                result[i + j] = result[i + j] + A[i] * B[j];
            }
        }
        return result;
    }
}
