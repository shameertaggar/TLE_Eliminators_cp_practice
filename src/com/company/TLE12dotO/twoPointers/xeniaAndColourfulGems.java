package com.company.TLE12dotO.twoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class xeniaAndColourfulGems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int nr = sc.nextInt();
            int ng = sc.nextInt();
            int nb = sc.nextInt();

            int[] r = new int[nr];
            for (int i = 0; i < nr; i++) {
                r[i] = sc.nextInt();
            }
            int[] g = new int[ng];
            for (int i = 0; i < ng; i++) {
                g[i] = sc.nextInt();
            }
            int[] b = new int[nb];
            for (int i = 0; i < nb; i++) {
                b[i] = sc.nextInt();
            }

            // Sorting the arrays to enable binary search
            Arrays.sort(r);
            Arrays.sort(g);
            Arrays.sort(b);

            // Get the minimum difference for all possible color combinations
            int result = Integer.MAX_VALUE;
            result = Math.min(result, checkColour(r, g, b));
            result = Math.min(result, checkColour(r, b, g));
            result = Math.min(result, checkColour(g, r, b));
            result = Math.min(result, checkColour(g, b, r));
            result = Math.min(result, checkColour(b, g, r));
            result = Math.min(result, checkColour(b, r, g));

            // Output the result
            System.out.println(result);
        }
    }

    private static int checkColour(int[] r, int[] g, int[] b) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < g.length; i++) {
            int low = lowerbound(r, g[i]);
            int high = upperbound(b, g[i]);

            // Ensure low and high are within bounds
            int rValue = (low < r.length) ? r[low] : Integer.MAX_VALUE;
            int bValue = (high < b.length) ? b[high] : Integer.MAX_VALUE;

            // Calculate the formula to minimize the distance
            double calc = Math.pow(rValue - g[i], 2) + Math.pow(bValue - g[i], 2) + Math.pow(bValue - rValue, 2);
            ans = Math.min(ans, (int) calc);
        }
        return ans;
    }

    private static int lowerbound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int upperbound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
