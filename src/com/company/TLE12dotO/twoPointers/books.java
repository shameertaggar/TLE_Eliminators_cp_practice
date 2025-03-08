package com.company.TLE12dotO.twoPointers;

import java.util.Scanner;

public class books {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        long n = sc.nextLong();
        long t = sc.nextLong();

        long arr[] = new long[(int)n];

        for (long i = 0; i < n; i++){
            arr[(int)i] = sc.nextLong();
        }

        long left = 0;
        long right = 0;
        long maxBooks = 0;
        long time = 0;

        while (right < n){
            time += arr[(int)right];

            while (time > t && left <= right){
                time -= arr[(int)left];
                left++;
            }
            maxBooks = Math.max(maxBooks, right - left + 1);
            right++;
        }

        System.out.println(maxBooks);
    }
}
