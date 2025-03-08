package com.company.TLE12dotO.numberTheory;

import java.util.Scanner;

public class rowGCD {
    public static long gcdOfArray(long[] arr) {
        long result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
            // If at any point GCD becomes 1, we can stop as it's the smallest possible GCD
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }

    // Helper function to compute GCD of two numbers using Euclidean algorithm
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] arr = new long[n];
        long z = sc.nextLong();
        for (int i = 0; i < n-1; i++) {
            arr[i] = Math.abs(sc.nextLong()-z);
        }

        long[] brr = new long[m];
        for (int i = 0; i < m; i++) {
            brr[i] = sc.nextLong();
        }

        long preGcd = gcdOfArray(arr);
        for (int i = 0; i<m; i++){
            long ans = gcd(z+brr[i],preGcd);
            System.out.print(ans+ " ");
        }

    }

}
