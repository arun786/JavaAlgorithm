package week2.FibonacciSeries.GCD;

import java.math.BigInteger;

public class NaiveAlgo {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(NaiveGCD(578986, 267896));
        long end = System.currentTimeMillis();
        System.out.println("time taken " + (end - start) + " ms"); //31 ms
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
