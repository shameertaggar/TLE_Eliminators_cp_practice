package com.company.virtualContests.C_problems;

import java.util.Scanner;

public class superUltraFavouritePermutation {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // Process each test case using while loop
        int idx = 0;
        while (idx < t) {
            int n = sc.nextInt();
            idx++;

            if (n <= 4) {
                System.out.println(-1);
                continue;
            }

            // Print odd numbers up to n, skipping 5
            for (int i = 1; i <= n; i += 2) {
                if (i == 5) {
                    continue;
                }
                System.out.print(i + " ");
            }

            // Print 54
            System.out.print("5 4 ");

            // Print even numbers up to n, skipping 4
            for (int i = 2; i <= n; i += 2) {
                if (i == 4) {
                    continue;
                }
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }



}
