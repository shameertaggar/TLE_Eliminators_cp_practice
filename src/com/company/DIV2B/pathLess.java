package com.company.DIV2B;

import java.util.Scanner;

public class pathLess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            int s = sc.nextInt();
            int arr[] = new int[n];
            int c0 = 0;
            int c1 = 0;
            int c2 = 0;
            for (int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
                if(arr[i] == 0) c0++;
                if(arr[i] == 1) c1++;
                if(arr[i] == 2) c2++;
            }

            int sum = c1 + c2*2;
            if (s < sum){
                printArr(arr);
                continue;
            }
            if (s == sum){
                System.out.println(-1);
                continue;
            }

            int diff = s-sum;
            if(diff > 1){
                System.out.println(-1);
                continue;
            }

            while (c0 > 0){
                System.out.print(0 + " ");
                c0--;
            }
            while (c2 > 0){
                System.out.print(2 + " ");
                c2--;
            }

            while (c1 > 1){
                System.out.print(1 + " ");
                c1--;
            }
            System.out.print(1);
            System.out.println();




        }
    }

    private static void printArr(int[] arr) {
        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

