package week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MinimumCoins {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int den[] = {1, 5, 6};
        int number = getMinimumCoins(n, den);
        System.out.println(number);
    }

    public static int getMinimumCoins(int amount, int[] denominations) {

        int[] money = new int[amount + 1];

        int numOfCoins = 0;
        money[0] = 0;


        for (int i = 1; i <= amount; i++) {
            money[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < denominations.length; j++) {

                int coin = denominations[j];
                if (i >= coin) {
                    numOfCoins = money[i - coin] + 1;
                }

                if (numOfCoins < money[i]) {
                    money[i] = numOfCoins;
                }
            }
        }
        return money[amount];
    }

}
