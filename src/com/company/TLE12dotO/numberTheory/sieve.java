package com.company.TLE12dotO.numberTheory;

import java.util.Arrays;

public class sieve {

    public static void isPrime(int n, int arr[]){
        Arrays.fill(arr,1);
        arr[0] = 0;
        arr[1] = 0;

        for (int i = 2; i*i <=n; i++){
            if (arr[i] == 1){
                for (int j = i*i; j <=n; j += i){
                    arr[j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int n = 100000000;
        int arr[] = new int[n+1];
        isPrime(n,arr);

        int k = 0;
        for (int i = 0; i<=n; i++){
            if (arr[i] == 1){
                k++;
                System.out.print(i + " ");
                if (k == 10){
                    System.out.println();
                    k = 0;
                }
            }
        }
    }
}
