package week3;

import java.util.Scanner;

public class change {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int result = getNumberOfMinimumCoins(number);
        System.out.println(result);


    }

    public static int getNumberOfMinimumCoins(int number) {
        int[] coins = {10, 5, 1};
        int length = 0;
        for (int i = 0; i < coins.length; i++) {
            while(coins[i] <= number){
                number = number - coins[i];
                length++;
            }
        }
        return length;
    }
}
