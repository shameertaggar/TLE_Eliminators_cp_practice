package com.company.cp31sheet.rating1200;

import java.util.HashMap;
import java.util.Scanner;

public class Matryoshkas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }
            

        }
    }
}
