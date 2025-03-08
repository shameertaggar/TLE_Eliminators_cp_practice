package com.company.TLE12dotO.binarySearch;

import java.util.Scanner;

public class ropes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];

        float end = 0;
        float start = 0;
        for (int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
            end = Math.max(end,arr[i]);

        }

        float ans = 0;
        int i = 0;
        while(end - start > 1e-6 && i < 100){
            float mid = start + (end-start)/2;
            if(checkBs(mid,arr,k)){

                ans = mid;
                start = mid;
            }else{
                end = mid;
            }
            i++;
        }
        System.out.printf("%.7f\n", ans);

    }

    private static boolean checkBs(double mid, int[] arr, int k) {
        int built = 0;
        for(int i = 0; i<arr.length; i++){
            built += arr[i]/mid;
        }
        if (built >= k){
            return true;
        }
        return false;
    }
}
