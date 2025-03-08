package com.company.cp31sheet.rating1200;

import java.util.Scanner;

public class friendsAndTheRestaurants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int spend[] = new int[n];
            for (int i = 0; i<n; i++){
                spend[i] = sc.nextInt();
            }
            int has[] = new int[n];
            for (int i = 0; i<n; i++){
                has[i] = sc.nextInt();
            }
        }
    }
}
