package com.company.TLE12dotO.twoPointers;

import java.util.Scanner;

public class cheCity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int r = sc.nextInt();
         int arr[] = new int[n];

         for (int i = 0; i<n; i++){
             arr[i] = sc.nextInt();
         }

         int left = 0;
         int right = 0;
         int cnt = 0;
         while(right < n){
             while (arr[right] - arr[left] > r){
                 cnt += n-right;
                 left++;
             }
             right++;
         }
        System.out.println(cnt);
    }
}

//4 3
//        1 2 3
//        3 2 1
//        1 2 1
//        4 2 7

// 2+0+3+0+2+2+4 = 13
// 2+1+6 = 9
// 3+0+6 = 9
