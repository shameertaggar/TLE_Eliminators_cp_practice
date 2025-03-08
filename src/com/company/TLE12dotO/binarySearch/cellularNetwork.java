package com.company.TLE12dotO.binarySearch;

import java.util.Scanner;

public class cellularNetwork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] city = new int[n];
        for (int i = 0; i < n; i++) {
            city[i] = sc.nextInt();
        }

        int[] tower = new int[m];
        for (int i = 0; i < m; i++) {
            tower[i] = sc.nextInt();
        }



        int start = 0;
        int end = Math.max(Math.abs(city[0] - tower[m - 1]), Math.abs(city[n - 1] - tower[0]));
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canCoverAllCities(mid, city, tower)) {
                ans = mid; // Valid radius found
                end = mid - 1; // Try for a smaller radius
            } else {
                start = mid + 1; // Increase the radius
            }
        }

        System.out.println(ans); // Final result
    }

    private static boolean canCoverAllCities(int radius, int[] city, int[] tower) {
        int i = 0, j = 0;

        while (i < city.length && j < tower.length) {
            if (Math.abs(city[i] - tower[j]) <= radius) {
                // Current city is covered by the current tower
                i++;
            } else {
                // Move to the next tower to try covering the city
                j++;
            }
        }

        // If we covered all cities, return true
        return i == city.length;
    }
}
