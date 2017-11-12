package week2.Fibonacci;

import java.math.BigInteger;
import java.util.Scanner;

public class fibonacci_partial_sum {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        BigInteger num1 = scan.nextBigInteger();
        BigInteger num2 = scan.nextBigInteger();

        BigInteger pisanoNum1 = num1.mod(BigInteger.valueOf(60)); //60 is the pisano period of 10
        BigInteger pisanoNum2 = num2.mod(BigInteger.valueOf(60));

        if (pisanoNum1.intValue() > pisanoNum2.intValue()) {
            System.out.println(GetFibonnaciNumber(pisanoNum2, pisanoNum1));
        } else {
            System.out.println(GetFibonnaciNumber(pisanoNum1, pisanoNum2));
        }


    }

    public static BigInteger GetFibonnaciNumber(BigInteger num1, BigInteger num2) {
        BigInteger fb[] = new BigInteger[num1.intValue() + 1];

        BigInteger fibonaccinumberAtNum1 = BigInteger.ZERO;
        BigInteger fibonaccinumberPrevToNum1 = BigInteger.ZERO;
        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < num1.intValue() + 1; i++) {
            if (i == 0 || i == 1) {
                fb[i] = BigInteger.valueOf(i);
            } else {
                fb[i] = fb[i - 1].add(fb[i - 2]).mod(BigInteger.valueOf(10));
            }
            if (i == 0) {
                fibonaccinumberAtNum1 = fb[i];
            } else {
                fibonaccinumberAtNum1 = fb[i];
                fibonaccinumberPrevToNum1 = fb[i - 1];
            }
        }


        BigInteger finalResult = fibonaccinumberAtNum1;
        if (num1.intValue() == num2.intValue())
            return finalResult;



        for (int j = num1.intValue(); j < num2.intValue(); j++) {
            result = fibonaccinumberPrevToNum1.add(fibonaccinumberAtNum1).mod(BigInteger.valueOf(10));
            finalResult = finalResult.add(result).mod(BigInteger.valueOf(10));
            fibonaccinumberPrevToNum1 = fibonaccinumberAtNum1;
            fibonaccinumberAtNum1 = result;
        }

        return finalResult;
    }


}
