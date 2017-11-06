package week2.FibonacciSeries.GCD;

import java.math.BigInteger;

public class NaiveAlgo {

    public static void main(String[] args) {
        System.out.println(NaiveGCD(5, 20));
    }

    static Integer NaiveGCD(Integer num1, Integer num2) {
        Integer best = 0;
        for (Integer b = 2; b < num1 + num2; b++) {
            if (num1 % b == 0 && num2 % b == 0) {
                best = b;
            }
        }
        return best;
    }
}
