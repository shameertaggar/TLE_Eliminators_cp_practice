package com.company.TLE12dotO.twoPointers;

import java.util.HashMap;
import java.util.Scanner;

public class segmentsWithSmallSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        long ans = 0;
        while (right < n){
            map.put(arr[right], map.getOrDefault(arr[right],0)+1);
            while (map.size() > k){
                map.put(arr[left],map.get(arr[left])-1);
                if(map.get(arr[left]) == 0){
                    map.remove(arr[left]);
                }
                left++;
            }

            ans += right-left+1;
            right++;
        }
        System.out.println(ans);
    }

}
