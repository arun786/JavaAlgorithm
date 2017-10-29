package assignment2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaxPairwiseProduct {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Long a = scan.nextLong();
        List<BigInteger> lst = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            lst.add(scan.nextBigInteger());
        }
        Collections.sort(lst, Collections.reverseOrder());

        BigInteger result = lst.get(0).multiply(lst.get(1));
        System.out.println(result);
    }
}

//5
//20000 30000 5000 5000 300
//multiple maximum of the two numbers from the second line
