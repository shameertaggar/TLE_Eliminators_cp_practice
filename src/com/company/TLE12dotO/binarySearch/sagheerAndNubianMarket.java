package com.company.TLE12dotO.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class sagheerAndNubianMarket {

    static long costt = 0;

    public static void main(String[] args) {
        costt = 0;
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long s = sc.nextLong();

        long arr[] = new long[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long start = 0;
        long end = n;
        long ans = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (checkK(arr, mid, s)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(ans + " " + costt);
    }

    private static boolean checkK(long[] arr, long mid, long s) {
        long[] tempCosts = new long[arr.length];

        // Calculate the effective costs
        for (int i = 0; i < arr.length; i++) {
            tempCosts[i] = arr[i] + (i + 1) * mid;
        }

        // Sort the costs
        Arrays.sort(tempCosts);

        long cost = 0;

        // Sum the smallest mid costs
        for (int i = 0; i < mid; i++) {
            cost += tempCosts[i];
            if (cost > s) {
                return false;
            }
        }

        costt = cost;
        return true;
    }

}
