package com.company.TLE12dotO.binarySearch;

import java.util.Scanner;

public class keshiIsThrowingAParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int arr[][] = new int[n][2];
            for (int i = 0; i<n; i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            
            int start = 0;
            int end = n;
            int ans = 0;
            while (start <= end){
                int mid = start + (end-start)/2;
                if(invite(mid,arr)){
                    ans = mid;
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }

            System.out.println(ans);

        }
    }

    private static boolean invite(int mid, int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            // Check if the current friend can be included in the party
            if (arr[i][1] >= count && arr[i][0] >= mid-count-1  ) {
                count++; // Invite this friend
                if (count >= mid) {
                    return true; // Successfully invited `mid` people
                }
            }

        }

        return false;
    }

}
