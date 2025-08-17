package com.company.DIV2B;

import java.util.Scanner;

public class makeItPermutation {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();

            int arr[][] = new int[n][n];
            int b[] = new int[n];
            for(int i =1; i<=n; i++){
                b[i-1] = i;
            }

            int a = 2;
            int bb = 1;
            int c = 2;

            // small to big
            System.out.println(2*(n-1));
            for (int i = 0; i<n-1; i++){
                System.out.println(a++ +" " + bb + " " + c++);
            }
            a = 1;
            bb = 2;
            c = n;
            for (int i = 0; i<n-1; i++){
                System.out.println(a++ +" " + bb++ + " " + c);
            }

        }
    }
}
