package com.company.conceptPractice.bitMask;

import java.util.Scanner;

public class rockAndLever {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            int[] msbCount = new int[32]; 


            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                int msb = 31 - Integer.numberOfLeadingZeros(arr[i]);
                msbCount[msb]++;
            }

            long totalPairs = 0;
            for (int count : msbCount) {
                if (count > 1) {
                    totalPairs += (long) count * (count - 1) / 2;
                }
            }
            System.out.println(totalPairs);
        }
        sc.close();
    }
}
