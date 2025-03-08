package com.company.TLE12dotO.twoPointers;

import java.util.Scanner;

public class knapsackOnASegement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int w[] = new int[n];

        for (int i = 0; i<n; i++){
            w[i] = sc.nextInt();

        }
        int c[] = new int[n];

        for (int i = 0; i<n; i++){
            c[i] = sc.nextInt();
        }


        int left = 0;
        int right = 0;
        long ans = 0;
        int wt = 0;
        int pr = 0;
        while (right < n){
            wt += w[right];
            pr += c[right];
            while (wt > s){
                wt -= w[left];
                pr -= c[left];
                left++;
            }
            ans = Math.max(ans,pr);
            right++;

        }

        System.out.println(ans);


    }
}
