package com.company.TLE12dotO.numberTheory;

import java.util.Scanner;

public class lunaticNeverContent {

        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();  // Number of test cases
            while (t-- > 0) {
                int n = sc.nextInt();  // Number of elements
                long[] arr = new long[n];  // Use long array to store large values
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextLong();
                }

                long gcdDiff = 0;  // GCD of differences
                int i = 0;
                int j = n - 1;

                while (i < j) {
                    long diff = Math.abs(arr[i] - arr[j]);
                    gcdDiff = gcd(gcdDiff, diff);  // Update GCD of all differences
                    i++;
                    j--;
                }

                // If all elements are equal, gcdDiff will be 0, meaning infinitely large x is possible
                System.out.println(gcdDiff == 0 ? 0 : gcdDiff);
            }
            sc.close();
        }

        // GCD method to handle large values
        public static long gcd ( long a, long b){
            while (b != 0) {
                long temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
}


