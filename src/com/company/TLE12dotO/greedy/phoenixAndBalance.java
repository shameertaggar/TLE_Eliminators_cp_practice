package com.company.TLE12dotO.greedy;

import java.util.Scanner;

public class phoenixAndBalance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            arr[0] = 2;
            for (int i = 1; i<n;i++){
                arr[i] = arr[i-1]*2;
            }

            int a = arr[n-1];
            int b = arr[n/2-1];

            for (int i = 0; i<n/2-1; i++){
                a += arr[i];
            }
            for (int i = n/2; i< n-1;i++){
                b+= arr[i];
            }

            System.out.println(Math.abs(a-b));
        }
    }
}
