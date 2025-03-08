package com.company.conceptPractice.bitMask;

import java.util.Arrays;
import java.util.Scanner;

public class mochaAndMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            int result = arr[0];
            for (int i = 1; i < n; i++) {
                result &= arr[i];  // Perform AND operation with each element
            }
            System.out.println(result);  // Output the final result
        }
    }
}
