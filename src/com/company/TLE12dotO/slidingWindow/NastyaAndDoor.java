package com.company.TLE12dotO.slidingWindow;

import java.util.Scanner;

public class NastyaAndDoor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            int peak[] = new int[n];
            peak[0] = 0;
            peak[n-1] = 0;
            for (int i = 1; i<n-1; i++){
                if (arr[i-1] <arr[i] && arr[i] > arr[i+1]){
                    peak[i] = 1;
                    continue;
                }
                peak[i] = 0;
            }
//            for (int i = 0; i<n; i++){
//                System.out.print(peak[i] + " ");
//            }
//            System.out.println();

            for (int i = 1; i<n; i++){
                peak[i] += peak[i-1];
            }
//            for (int i = 0; i<n; i++){
//                System.out.print(peak[i] + " ");
//            }
//            System.out.println();

            int maxPeaks = 0;
            int bestStartIndex = 0;

            // Sliding window to find the best segment
            for (int i = 0; i <= n - k; i++) {
                // Peaks in the range [i + 1, i + k - 2]
                int currentPeaks = peak[i + k - 2] - peak[i];
                if (currentPeaks > maxPeaks) {
                    maxPeaks = currentPeaks;
                    bestStartIndex = i;
                }
            }

            
            // Output result: max parts = maxPeaks + 1, and 1-based index
            System.out.println((maxPeaks + 1) + " " + (bestStartIndex + 1));
        }
    }
}
