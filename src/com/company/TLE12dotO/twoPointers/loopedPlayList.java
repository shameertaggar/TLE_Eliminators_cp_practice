package com.company.TLE12dotO.twoPointers;

import java.util.Scanner;

public class loopedPlayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();

        int arr[] = new int[n];
        int sum = 0;
        for (int i = 0 ; i<n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int temp = 0;

        if (sum < p){
            temp += p/sum;
            p = p%sum;
        }
        int start = -1;
        int cnt = Integer.MAX_VALUE;

        for (int i = 0; i<n; i++){
            int summ = 0;
            int j = i;
            int taken = 0;
            while (summ < p){
                summ += arr[j];
                taken++;
                j = ++j%n;
            }

            if (taken < cnt){
                cnt = taken;
                start = i;
            }
        }

        int tot = temp*n + cnt;
        System.out.println(start+1 + " " + tot);

    }
}
