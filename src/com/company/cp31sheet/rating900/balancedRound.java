package com.company.cp31sheet.rating900;

import java.util.Arrays;
import java.util.Scanner;

public class balancedRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();  // Change t to long
        while (t-- > 0){
            long n = sc.nextLong();  // Change n to long
            long k = sc.nextLong();  // Change k to long
            long[] arr = new long[(int) n];  // Change arr[] to long[]

            for (int i = 0; i < n; i++){
                arr[i] = sc.nextLong();  // Change arr[i] to long
            }

            long[] left = new long[(int) n];  // Change left[] to long
            left[0] = 0;
            Arrays.sort(arr);
            for (int i = 1; i < n; i++){
                left[i] = arr[i] - arr[i-1];
            }

            long[] right = new long[(int) n];  // Change right[] to long
            right[(int) n-1] = 0;
            for (int i = (int) n-2; i >= 0; i--){
                right[i] = arr[i+1] - arr[i];
            }

            long lAns = 0;  // Change lAns to long
            long l = 0;  // Change l to long
            for (int i = 0; i < n; i++){
                if (left[i] > k){
                    lAns = Math.max(l, lAns);
                    l = 0;
                }
                l++;
            }

            long rAns = 0;  // Change rAns to long
            long r = 0;  // Change r to long
            for (int i = (int) n-1; i >= 0; i--){
                if (right[i] > k){
                    rAns = Math.max(r, rAns);
                    r = 0;
                }
                r++;
            }

            if (lAns != 0 && rAns != 0){
                System.out.println(Math.min(n - lAns, n - rAns));  // Use long subtraction
            } else {
                System.out.println(0);
            }
        }
    }
}
