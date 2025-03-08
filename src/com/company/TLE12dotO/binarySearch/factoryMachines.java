package com.company.TLE12dotO.binarySearch;

import java.util.Scanner;

public class factoryMachines {
    public static boolean check(long time, int[] arr, long t) {
        long products = 0;
        for (int machineTime : arr) {
            products += time / machineTime;
            if (products >= t) return true;
        }
        return products >= t;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of machines
        long t = sc.nextLong(); // Number of products to be made
        int[] arr = new int[n];
        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            minTime = Math.min(minTime, arr[i]);
        }

        long start = 1; // Minimum possible time
        long end = t * minTime; // Maximum possible time
        long ans = end;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (check(mid, arr, t)) {
                ans = mid; // Update answer to the current feasible time
                end = mid - 1; // Try for a smaller time
            } else {
                start = mid + 1; // Increase time
            }
        }

        System.out.println(ans);
    }
}
