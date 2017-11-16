package week3;

import java.math.BigInteger;
import java.util.*;

public class dot_product {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long noi = scan.nextLong();
        List<BigInteger> firstList = new ArrayList<>();
        List<BigInteger> secondList = new ArrayList<>();
        for (int i = 0; i < noi; i++) {
            firstList.add(scan.nextBigInteger());
        }
        Collections.sort(firstList, Collections.reverseOrder());
        for (int i = 0; i < noi; i++) {
            secondList.add(scan.nextBigInteger());
        }
        Collections.sort(secondList, Collections.reverseOrder());

        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < noi; i++) {
            result = result.add(firstList.get(i).multiply(secondList.get(i)));
        }

        System.out.println(result);
    }
}
