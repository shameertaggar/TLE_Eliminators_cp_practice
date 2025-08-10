package com.company.contest10Aug;

import java.util.Scanner;

public class adjacentXor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();

            int arr[] = new int[n];
            int brr[] = new int[n];

            for (int i = 0; i<n; i++){
                arr[i] = sc.nextInt();

            }

            for (int i = 0; i<n; i++){
                brr[i] = sc.nextInt();
            }

            if(brr[n-1] != arr[n-1]){
                System.out.println("No");
                continue;
            }
            boolean poss = true;
            for (int i = n-2; i>=0; i--){
                int a1 = arr[i];
                int a2 = arr[i]^arr[i+1];
                int a3 = arr[i]^brr[i+1];
                int b1 = brr[i];
                if(brr[i] != a1 && b1 != a2 && a3 != b1 ){
                    poss = false;
                    break;
                }

            }

            if (poss){
                System.out.println("YEs");
            }else{
                System.out.println("No");
            }
        }
    }
}
