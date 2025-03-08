package com.company.TLE12dotO.twoPointers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class kefaAndCompany {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[][] arr = new int[n + 1][2];  // Use n+1 for 1-based indexing
        arr[0][0] = 0;
        arr[0][1] = 0;

        for (int i = 1; i <= n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });



        int left = 1;
        int maxF = 0;
        int curr = 0;
        for (int right = 1; right <= n; right++) {
            while (arr[right][0] - arr[left][0] >= d) {
                curr -= arr[left][1];
                left++;
            }
            curr += arr[right][1];
            maxF = Math.max(maxF, curr);
        }

        System.out.println(maxF);
    }
}
