package week2.Fibonacci;

import java.math.BigInteger;
import java.util.Scanner;

public class fibonnaci_sum_last_digit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BigInteger number = scan.nextBigInteger();

        BigInteger resultant = number.mod(BigInteger.valueOf(60));
        int size = resultant.intValue() + 1;
        BigInteger fb[] = new BigInteger[size];
        BigInteger lastDigit = BigInteger.ZERO;

        for (int i = 0; i < size; i++) {
            if (i == 0 || i == 1) {
               fb[i] = BigInteger.valueOf(i);
            } else {
                fb[i] = fb[i - 1].add(fb[i - 2]).mod(BigInteger.valueOf(10));
            }
            lastDigit = lastDigit.add(fb[i]);
        }

        System.out.println(lastDigit.mod(BigInteger.valueOf(10)));
    }
}
