package week2.Fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fibonacci_huge {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        BigInteger num1 = scan.nextBigInteger();
        BigInteger num2 = scan.nextBigInteger();

        int length = pisano(num1, num2);
        BigInteger fibonacciNumber = num1;
        if (length != 0) {
            fibonacciNumber = num1.mod(BigInteger.valueOf(length));
        }

        System.out.println(getFibbonacciNumber(fibonacciNumber, num2.intValue()));
    }

    public static BigInteger getFibbonacciNumber(BigInteger number, Integer mod) {
        BigInteger size = number.add(BigInteger.ONE);
        BigInteger[] fb = new BigInteger[size.intValue()];
        List<BigInteger> pasino = new ArrayList<>();
        int flag = 0;
        for (int i = 0; i <= number.intValue(); i++) {
            if (i == 0 || i == 1) {
                fb[i] = BigInteger.valueOf(i);
            } else {
                fb[i] = fb[i - 1].add(fb[i - 2]);
            }
        }
        return fb[number.intValue()].mod(BigInteger.valueOf(mod));
    }

    public static Integer pisano(BigInteger number, BigInteger mod) {
        List<BigInteger> fb = new ArrayList<>();
        List<BigInteger> pasino = new ArrayList<>();
        int maxSize = Integer.MAX_VALUE;
        int flag = 0;
        for (int i = 0; i < maxSize ; i++) {
            if (i == 0 || i == 1) {
                fb.add(BigInteger.valueOf(i));
            } else {
                fb.add(fb.get(i - 1).add(fb.get(i - 2)));
            }

            BigInteger series = fb.get(i).mod(mod);

            if ((i != 0 && i != 1) && (series.intValue() == 0 || series.intValue() == 1)) {
                flag++;
            } else {
                flag = 0;
            }

            if (flag == 2) {
                break;
            } else {
                pasino.add(series);
            }
        }
        if (flag == 2) {
            return pasino.size();
        } else {
            return 0;
        }
    }
}
