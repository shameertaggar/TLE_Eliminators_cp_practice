package com.company.TLE12dotO.binarySearch;

import java.util.Scanner;

public class arrayDivision {

    public  static  boolean check(int x, int arr[], int k){
        int used = 1;
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            if(sum + arr[i] <= x){
                sum += arr[i];
            }else{
                used++;
                if(used > k || arr[i] > x) return false;
                sum = arr[i];
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        int sum = 0;

        for (int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int start = 0;
        int end = sum;
        int mid = start + (end-start)/2;
        int ans = 0;
        while (start <= end){
            if(check(mid,arr,k)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
            mid = start + (end-start)/2;
        }

        System.out.println(ans);


    }
}
