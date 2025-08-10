package com.company.contest10Aug;

import java.util.Scanner;

public class lever {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            int surplus = 0;
            for (int i = 0; i < n; i++) {
                surplus += Math.max(a[i] - b[i], 0);
            }

            // Add 1 for the final iteration where step 1 is skipped
            System.out.println(surplus + 1);
        }

        sc.close();
    }
}
