package com.company.TLE12dotO.binarySearch;

import java.util.*;

public class saveTheNature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int n = sc.nextInt();
            long[] p = new long[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextLong();
            }
            int x = sc.nextInt();
            int a = sc.nextInt();
            int y = sc.nextInt();
            int b = sc.nextInt();
            long k = sc.nextLong();

            Arrays.sort(p);

            int ans = -1;
            int start = 1;
            int end = n;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (sold(mid, p, k, x, a, y, b)) {
                    ans = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            System.out.println(ans);
        }
    }

    private static boolean sold(int mid, long[] p, long k, int x, int a, int y, int b) {
        // Sorting in descending order for maximizing contribution
        long[] sortedPrices = Arrays.copyOf(p, mid);
        Arrays.sort(sortedPrices);
        reverseArray(sortedPrices);

        long totalContribution = 0;

        int lcm = lcm(a, b); // Tickets that are in both programs
        int countLcm = mid / lcm;
        int countA = mid / a - countLcm; // Tickets only in first program
        int countB = mid / b - countLcm; // Tickets only in second program

        int idx = 0;

        // Calculate contribution for tickets in both programs
        while (countLcm-- > 0 && idx < sortedPrices.length) {
            totalContribution += sortedPrices[idx] * (x + y) / 100;
            idx++;
        }

        // Calculate contribution for tickets only in first program
        while (countA-- > 0 && idx < sortedPrices.length) {
            totalContribution += sortedPrices[idx] * x / 100;
            idx++;
        }

        // Calculate contribution for tickets only in second program
        while (countB-- > 0 && idx < sortedPrices.length) {
            totalContribution += sortedPrices[idx] * y / 100;
            idx++;
        }

        return totalContribution >= k;
    }

    private static void reverseArray(long[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            long temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
