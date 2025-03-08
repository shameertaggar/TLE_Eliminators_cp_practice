package com.company.conceptPractice.bitMask;

import java.util.Scanner;

public class xorMixup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();  // Number of elements in the shuffled array
            int[] a = new int[n];
            int xorAll = 0;

            // Read array and compute XOR of all elements
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                xorAll ^= a[i];  // XOR all numbers
            }

            // Since `xorAll` = x, find the number appearing more than once
            for (int i = 0; i < n; i++) {
                if (xorAll == a[i]) {
                    System.out.println(a[i]);
                    break;  // We found x, exit the loop
                }
            }
        }
        sc.close();
    }
}
