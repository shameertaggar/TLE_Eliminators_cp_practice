package com.company.DIV2B;

import java.util.Scanner;

public class jellyFIshBB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int p[] = new int[n];
            int q[] = new int[n];
            for (int i = 0; i<n; i++){
                p[i] = sc.nextInt();
            }
            for (int i = 0; i<n; i++){
                q[i] = sc.nextInt();
            }
        }
    }
}
