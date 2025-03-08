package com.company.TLE12dotO.binarySearch;

import java.util.Scanner;

public class forestGathering {

    public static boolean fulfill(long mid, long[][] hr, long w, long l) {
        long wood = 0;
        for (int i = 0; i < hr.length; i++) {
            long height = hr[i][0] + (hr[i][1] * mid);
            if (height >= l) {
                wood += height - l; // Only add the excess wood above l
                if (wood >= w) return true; // Early exit if we have enough wood
            }
        }
        return wood >= w;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of trees
        long w = sc.nextLong(); // Required wood
        long l = sc.nextLong(); // Minimum height to start cutting

        long[][] hr = new long[n][2];
        for (int i = 0; i < n; i++) {
            hr[i][0] = sc.nextLong(); // Initial height of the tree
            hr[i][1] = sc.nextLong(); // Rate of growth per month
        }

        long start = 0;
        long end = (long) 1e18;
        long ans = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (fulfill(mid, hr, w, l)) {
                ans = mid;
                end = mid - 1; // Try to find a smaller valid month
            } else {
                start = mid + 1; // Increase the month to collect enough wood
            }
        }

        System.out.println(ans);
    }
}
