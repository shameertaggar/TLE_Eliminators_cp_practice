package com.company.contest10Aug;

import java.util.Scanner;

public class alternatingSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();

            int arr[] = new int[n];

            for(int i = 0; i<n; i++){
                if(i%2 == 0){
                    arr[i] = -1;
                }else{
                    arr[i] = 3;
                }
            }
            arr[n-2] = 2;
            for (int i = 0; i<n; i++){
                if (i != n-1){
                    System.out.print(arr[i] + " ");
                }else{
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
        }
    }
}
