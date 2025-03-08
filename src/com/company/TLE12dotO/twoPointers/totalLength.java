package com.company.TLE12dotO.twoPointers;

import java.util.Scanner;

public class totalLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long s = sc.nextLong();
        long[] arr = new long[n]; // Convert array to long

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong(); // Read input as long
        }

        long left = 0;
        long right = 0;
        long sum = 0;
        long ans = 0;

        while (right < n) {
            sum += arr[(int) right]; // Use casting to index array

            while (sum > s) {
                sum -= arr[(int) left]; // Use casting to index array
                left++;
            }

            long len = right - left + 1;
            ans += (len * (len + 1)) / 2;
            right++;
        }

        System.out.println(ans);
    }
}
