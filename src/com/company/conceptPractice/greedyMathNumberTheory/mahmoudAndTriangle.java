package com.company.conceptPractice.greedyMathNumberTheory;

import java.util.Arrays;
import java.util.Scanner;

public class mahmoudAndTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Number of line segments
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();  // Length of each segment
        }

        Arrays.sort(arr);  // Sort the array to simplify triangle inequality checks

        boolean found = false;

        // Check for any triplet that satisfies the triangle inequality
        for (int i = 0; i < n - 2; i++) {
            if (arr[i] + arr[i + 1] > arr[i + 2]) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
