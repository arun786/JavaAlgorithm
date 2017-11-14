package week2;

import java.math.BigInteger;
import java.util.Scanner;

public class LeastCommonFactor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger num1 = scan.nextBigInteger();
        BigInteger num2 = scan.nextBigInteger();
        BigInteger gcd = GCD(num1,num2);
        BigInteger lcm = (num1.multiply(num2)).divide(gcd);
        System.out.println(lcm);
    }

    public static BigInteger GCD(BigInteger num1, BigInteger num2) {
        if (num2.equals(BigInteger.ZERO)) {
            return num1;
        }

        return GCD(num2, num1.mod(num2));
    }
}
