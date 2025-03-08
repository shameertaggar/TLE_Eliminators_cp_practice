package com.company.TLE12dotO.twoPointers;

import java.util.Scanner;
import java.util.TreeMap;

public class segmentsWithSmallSpread {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        TreeMap<Long, Integer> map = new TreeMap<>();
        int left = 0;
        long count = 0;

        for (int right = 0; right < n; right++) {

            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            count += (right - left + 1);
        }

        System.out.println(count);
    }
}
