package com.company.TLE12dotO.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class aggressiveCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int c = sc.nextInt();
            int arr[] = new int[n];

            int end = 0;
            for (int i =0 ; i<n; i++){
                arr[i] = sc.nextInt();
                end += arr[i];
            }
            Arrays.sort(arr);

            int start = 0;
            int mid = start + (end-start)/2;
            int ans = 0;
            while (start <= end){
                mid = start + (end-start)/2;
                if(checkBs(arr,mid,n,c)){
                    ans = mid;
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
            System.out.println(ans);
        }
    }

    private static boolean checkBs(int[] arr, int distance, int n, int cows) {
        int count = 1; // Place the first cow in the first stall
        int lastPosition = arr[0]; // Last stall position where a cow is placed

        for (int i = 1; i < n; i++) {
            if (arr[i] - lastPosition >= distance) {
                count++; // Place the cow
                lastPosition = arr[i]; // Update the last position

                if (count == cows) {
                    return true; // All cows are placed
                }
            }
        }

        return false;
    }
}
