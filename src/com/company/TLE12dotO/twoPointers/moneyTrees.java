package com.company.TLE12dotO.twoPointers;

import java.util.Scanner;

public class moneyTrees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // Number of trees
            long k = sc.nextLong(); // Maximum fruits allowed
            long[] a = new long[n];
            long[] h = new long[n];

            // Input the number of fruits in each tree
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            // Input the height of each tree
            for (int i = 0; i < n; i++) {
                h[i] = sc.nextLong();
            }

            int left = 0; // Start of the sliding window
            long fruits = 0; // Total fruits collected in the current window
            int maxLength = 0; // Maximum length of a valid subarray

            for (int right = 0; right < n; right++) {
                // Add the current tree's fruits
                fruits += a[right];

                // Check if the current tree breaks the divisibility condition
                if (right > 0 && h[right - 1] % h[right] != 0) {
                    // Reset the window since the condition is broken
                    left = right;
                    fruits = a[right];
                }

                // Shrink the window from the left if the total fruits exceed `k`
                while (fruits > k && left <= right) {
                    fruits -= a[left];
                    left++;
                }

                // Update the maximum length of a valid subarray
                maxLength = Math.max(maxLength, right - left + 1);
            }

            // Output the result for the current test case
            System.out.println(maxLength);
        }

        sc.close(); // Close the scanner
    }
}
