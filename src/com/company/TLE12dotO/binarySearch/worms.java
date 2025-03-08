package com.company.TLE12dotO.binarySearch;

import java.util.Scanner;

public class worms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        arr[0] = sc.nextInt();
        for (int i = 1; i<n; i++){
            arr[i] = sc.nextInt()+arr[i-1];
        }
        int m = sc.nextInt();
        int brr[] = new int[m];
        for (int i = 0; i<m; i++){
            brr[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int worm = brr[i];

            // Perform binary search to find the pile
            int start = 0;
            int end = n - 1;
            int result = -1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (worm <= arr[mid]) {
                    result = mid + 1; // Piles are 1-indexed
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            // Output the pile number for the current worm
            System.out.println(result);
        }
    }
}
