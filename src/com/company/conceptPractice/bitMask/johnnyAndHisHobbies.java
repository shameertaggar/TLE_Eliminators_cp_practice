package com.company.conceptPractice.bitMask;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class johnnyAndHisHobbies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
                set.add(arr[i]);
            }
            int ans = -1;
            for (int i = 1; i<1024; i++){
                Set<Integer> set2 = new HashSet<>();
                for (int j = 0; j<n ;j++){
                    int num = arr[j]^i;
                    set2.add(num);
                }
                if (ans == -1 && set.equals(set2)){
                    ans = i;
                }

            }
            System.out.println(ans);
        }
    }
}
