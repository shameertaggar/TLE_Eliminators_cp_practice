package com.company.TLE12dotO.binarySearch;

import java.util.Scanner;

public class getTogether {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long arr[][] = new long[n][2];


        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextLong();
            arr[i][1] = sc.nextLong();
        }


        double start = 0;
        double end = 1000000000;  // Set a large initial end value
        double mid;
        double ans = 0;

        // Binary search to find the optimal time
        while (end - start > 1e-7) {

            mid = start + (end - start) / 2;
            if (checkBs(arr, mid)) {
                ans = mid;
                end = mid;
            } else {
                start = mid;  // If not possible, increase the time
            }
        }


        System.out.println(ans);
    }


    private static boolean checkBs(long[][] arr, double mid) {
        double max_min_position = Long.MIN_VALUE;  // Track max of min positions
        double min_max_position = Long.MAX_VALUE;  // Track min of max positions

        // Calculate possible positions for each person
        for (int i = 0; i < arr.length; i++) {
            long position = arr[i][0];
            long speed = arr[i][1];

            double min_position = position - speed * mid;
            double max_position = position + speed * mid;


            max_min_position = Math.max(max_min_position, min_position);
            min_max_position = Math.min(min_max_position, max_position);
        }


        return max_min_position <= min_max_position;
    }
}
