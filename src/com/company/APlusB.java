package com.company;

import java.util.Scanner;

public class APlusB {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = scan.nextInt();
        int num2 = scan.nextInt();

        if (num1 >= 0 && num2 <= 9) {
            System.out.println(num1 + num2);
        } else if (num1 < 0 && num2 > 9) {
            System.out.println("First number should be greater than 0 and second number should be less than 9");
        } else if (num1 < 0) {
            System.out.println("First number should be greater than 0");
        } else {
            System.out.println("Second Number should be less than 9");
        }
    }
}
