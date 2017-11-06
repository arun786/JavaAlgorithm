package week2.Fibonacci;

import java.math.BigInteger;

public class NaiveAlgo {

    public static void main(String[] args) {
        System.out.println(fibonacci(50));
    }


    public static Integer fibonacci(Integer num) {
        if (num <= 1) {
            return num;
        }

        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
