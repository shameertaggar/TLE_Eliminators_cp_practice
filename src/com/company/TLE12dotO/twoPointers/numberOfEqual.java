package com.company.TLE12dotO.twoPointers;

import java.util.*;

public class numberOfEqual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input sizes of arrays
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Input array a
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Input array b
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        // Two-pointer technique
        int i = 0, j = 0;
        long count = 0;

        while (i < n && j < m) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                // Count occurrences of a[i] in array a
                int countA = 0, countB = 0;
                int currentA = a[i];
                while (i < n && a[i] == currentA) {
                    countA++;
                    i++;
                }

                // Count occurrences of b[j] in array b
                int currentB = b[j];
                while (j < m && b[j] == currentB) {
                    countB++;
                    j++;
                }

                // Add pairs to count
                count += (long) countA * countB;
            }
        }

        // Output the result
        System.out.println(count);

        sc.close();
    }
}

