package week2.Fibonacci;

import java.math.BigInteger;
import java.util.Scanner;

public class EfficientAlgo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int size = num + 1;

        BigInteger aNum[] = new BigInteger[size];

        if (num == 0) {
            aNum[num] = BigInteger.valueOf(num);
        }


        for (int i = 0; i < size; i++) {
            if (i < 2) {
                aNum[i] = BigInteger.valueOf(i);
            } else
                aNum[i] = aNum[i - 1].add(aNum[i - 2]);
        }

        BigInteger result = aNum[num];
        System.out.println(result);
    }
}
