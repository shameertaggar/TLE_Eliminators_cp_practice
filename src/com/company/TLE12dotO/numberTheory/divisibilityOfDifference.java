package com.company.TLE12dotO.numberTheory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class divisibilityOfDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        long m = sc.nextLong();
        long arr[] = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long mod[] = new long[n];
        Map<Long, Long> map = new HashMap<>();
        long max = -1;
        for (int i = 0; i < n; i++) {
            mod[i] = arr[i] % m;
            map.put(mod[i], map.getOrDefault(mod[i], 0L) + 1);
            if (map.get(mod[i]) == k) {
                max = mod[i];
            }
        }

        if (max == -1) {
            System.out.println("No");
            return;
        }

        long ans[] = new long[(int) k];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j < k && mod[i] == max) {
                ans[j++] = arr[i];
            }
        }
        System.out.println("Yes");

        for (int i = 0; i < k; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}