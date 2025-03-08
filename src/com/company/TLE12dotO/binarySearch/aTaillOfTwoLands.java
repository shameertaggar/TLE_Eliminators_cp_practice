package com.company.TLE12dotO.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class aTaillOfTwoLands {

    private static int upperBound(long[] arr, long key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long arr[] = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(sc.nextLong());
        }

        Arrays.sort(arr);

        long ans = 0;

        // Iterate over each element and find upper bound
        for (int i = 0; i < n; i++) {
            int upperIndex = upperBound(arr, 2 * arr[i]);
            ans += upperIndex - i - 1;
        }

        System.out.println(ans);
    }
}
