package com.company.TLE12dotO.numberTheory;

import java.util.Arrays;
import java.util.Scanner;

public class weWereBothChildren {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int freq[] = new int[200001];
            Arrays.fill(freq,0);
            for(int i = 0; i<n; i++){
                if (arr[i] >200000)continue;
                freq[arr[i]]++;
            }

            int trap[] = new int[n+1];
            Arrays.fill(trap,0);
            for (int h = 1; h<=n; h++){
                for (int i = h; i<=n; i+=h){
                    trap[i] += freq[h];
                }
            }

            int ans = 0;
            for (int i = 0; i<=n;i++){
                ans = Math.max(trap[i],ans);
            }
            System.out.println(ans);

        }
    }
}
