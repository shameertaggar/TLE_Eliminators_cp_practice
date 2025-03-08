package com.company.conceptPractice.bitMask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class andSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            List<Integer>list = new ArrayList<>();
            for (int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
                if (i != arr[i]){
                    list.add(i);
                }
            }

            int ans = list.get(0);
            for (int i = 1; i<list.size(); i++){
                ans = ans&list.get(i);
            }
            System.out.println(ans);
        }
    }
}
