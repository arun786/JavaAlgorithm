package week2.FibonacciSeries.GCD;

public class EfficientAlgo {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        System.out.println(GCD(578986, 267896)); //2
        long end = System.currentTimeMillis();

        System.out.println(end - start + " ms"); //0 ms
    }

    public static Integer GCD(Integer num1, Integer num2) {
        if (num2 == 0)
            return num1;
        return GCD(num2, num1 % num2);
    }
}
