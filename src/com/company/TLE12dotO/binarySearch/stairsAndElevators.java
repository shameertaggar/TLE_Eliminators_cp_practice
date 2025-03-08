package com.company.TLE12dotO.binarySearch;

import java.util.Scanner;

public class stairsAndElevators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int cl = sc.nextInt();
        int ce = sc.nextInt();
        int v = sc.nextInt();
        int arr[] = new int[cl];
        for (int i = 0; i<cl; i++){
            arr[i] = sc.nextInt();
        }

        int brr[] = new int[ce];
        for (int i = 0; i<ce; i++){
            brr[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int qrr[] = new int[q];
        for (int i = 0; i < q; i++){
            qrr[i] = sc.nextInt();
        }

    }
}
