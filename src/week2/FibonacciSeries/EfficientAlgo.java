package week2.FibonacciSeries;

import java.math.BigInteger;

public class EfficientAlgo {

    public static void main(String[] args) {
        System.out.println(fibonacci(50)[49]);
    }

    public static BigInteger[] fibonacci(Integer num) {

        BigInteger aNum[] = new BigInteger[num];
        for (int i = 0; i < num; i++) {
            if (i <= 2) {
                aNum[i] = BigInteger.valueOf(i);
            } else
                aNum[i] = aNum[i - 1].add(aNum[i - 2]);
        }
        return aNum;
    }
}
