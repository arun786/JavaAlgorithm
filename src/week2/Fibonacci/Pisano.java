package week2.Fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pisano {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BigInteger number = scan.nextBigInteger();
        BigInteger mod = scan.nextBigInteger();
        int length = pisano(number, mod);
        System.out.println(length);
    }

    public static Integer pisano(BigInteger number, BigInteger mod) {
        List<BigInteger> fb = new ArrayList<>();
        List<BigInteger> pasino = new ArrayList<>();
        int flag = 0;
        int limit = Integer.MAX_VALUE;
        for (int i = 0; i < limit; i++) {
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
