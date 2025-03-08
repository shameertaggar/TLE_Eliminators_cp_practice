package com.company.TLE12dotO.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class balancedStoneHeaps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i<n; i++){
                arr[i] = sc.nextInt();

            }

            int start = 0;
            int end = (int) 1e9;
            int ans = 0;
            while (start <= end){
                int mid = start + (end-start)/2;
                if (balanced(mid,arr)){
                    ans = mid;
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
            System.out.println(ans);
        }
    }

    private static boolean balanced(int mid, int[] arr) {
        int brr[] = Arrays.copyOf(arr,arr.length);

        for (int i = arr.length-1; i > 1; i--){
            if (brr[i] < mid) return false;

            else {
                int d = Math.min((brr[i]-mid)/3,arr[i]/3);
                    brr[i] -= 3*d;
                    brr[i-1] += d;
                    brr[i-2] += 2*d;

            }
        }

        if (brr[0] < mid || brr[1] < mid) return false;
        return true;

    }
}
