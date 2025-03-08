package com.company.TLE12dotO.twoPointers;

import java.util.HashMap;
import java.util.Scanner;

public class tvSubScription {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int d = sc.nextInt();

            int arr[] = new int[n];

            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            int left = 0;
            int right = 0;

            int maxDistinct = Integer.MAX_VALUE;
            while (right < n) {

                map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

                // If the window size is >= d, move the left pointer to shrink the window
                if (right - left + 1 > d) {
                    map.put(arr[left], map.get(arr[left]) - 1);
                    if (map.get(arr[left]) == 0) {
                        map.remove(arr[left]);
                    }
                    left++;
                }


                if (right - left + 1 == d) {
//                    maxDistinct = Math.min(maxDistinct, map.size());
                }

                right++;
            }

            System.out.println(maxDistinct);
        }
    }
}
