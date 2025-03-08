package com.company.TLE12dotO.binarySearch;

import java.util.Scanner;

public class jumpingThroughSegments {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){

            int n = sc.nextInt();
            int arr[][] = new int[n][2];

            int end = 0;
            for (int i = 0; i<n; i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                end = Math.max(end,arr[i][1]);
            }

            int start = 0;
            int ans = 0;

            while(start <= end){
                int mid = start + (end-start)/2;
                if(checkBs(mid,arr)){
                    ans = mid;
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }


            System.out.println(ans);
        }

    }

    private static boolean checkBs(int mid, int[][] arr) {

        // code for staying in segment
        int pmin = 0;
        int pmax = 0;

        for (int i = 0; i<arr.length; i++){
            pmin = Math.max(pmin-mid,arr[i][0]);
            pmax = Math.min(pmax+mid,arr[i][1]);
            if (pmax < pmin) return false;
        }

        return true;
    }
}
