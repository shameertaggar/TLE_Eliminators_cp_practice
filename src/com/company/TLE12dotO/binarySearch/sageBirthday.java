package com.company.TLE12dotO.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class sageBirthday {
    static int valley[] ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int start = 0;
        int end = n;
        int ans = 0;

        while (start <= end){
            int mid = start + (end - start)/2;
            if(checkValleys(mid,arr)){
           //     System.out.println("checking Valeeys Valid");
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(ans);

        for (int i = 0; i<arr.length; i++){
            System.out.print(valley[i] + " ");
        }


    }

    private static boolean checkValleys(int mid, int[] arr) {
        int count  = 0;

         valley = new int[arr.length];
        int j = 0;
        for (int i = 0; i<arr.length; i++){
            if (i%2 == 1){
                valley[i] = arr[j++];
            }
        }
        for (int i = 0; i<arr.length; i++){
            if (i%2 == 0){
                valley[i] = arr[j++];
            }
        }

        for (int i = 1; i<arr.length-1; i++){
            if (valley[i-1] > valley[i] && valley[i] < valley[i+1]){
           //     System.out.println("counted");
                count++;
            }
        }
        return count >= mid;
    }
}
