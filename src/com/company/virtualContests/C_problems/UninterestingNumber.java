package com.company.virtualContests.C_problems;

import java.util.Scanner;

public class UninterestingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String n = sc.next();
            int nlen = n.length();

            boolean solve = checkPossible(n, 0, nlen);
            if (solve) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean checkPossible(String n, int i, int len) {
        // Check if the sum of digits is divisible by 9
        if (sumDigits(n) % 9 == 0) return true;
        if (i >= len) return false;

        // Exclude the current digit
        boolean exc = checkPossible(n, i + 1, len);

        // Modify the ith digit if necessary and include it
        String modifiedNumber = modifyIthDigit(n, i);
        boolean inc = checkPossible(modifiedNumber, i + 1, len);

        return exc || inc;
    }

    // Sum of digits of a string number
    private static int sumDigits(String n) {
        int sum = 0;
        for (char ch : n.toCharArray()) {
            sum += ch - '0';
        }
        return sum;
    }

    // Modify the digit at the ith position
    public static String modifyIthDigit(String number, int index) {
        StringBuilder modifiedNumber = new StringBuilder(number);

        char digit = number.charAt(index);
        if (digit == '2' || digit == '3') {
            // Square the digit and replace it
            int squared = (digit - '0') * (digit - '0');
            String squaredStr = Integer.toString(squared);
            modifiedNumber.replace(index, index + 1, squaredStr);
        }

        return modifiedNumber.toString();
    }
}
