package com.company.cp31sheet.rating900;

import java.util.Arrays;
import java.util.Scanner;

public class jellyFishAndUndertale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();  // Change t to long
        while (t-- > 0) {
            long a = sc.nextLong();  // Change a to long
            long b = sc.nextLong();  // Change b to long
            long n = sc.nextLong();  // Change n to long
            long[] arr = new long[(int) n];  // Change arr to long[]

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();  // Change arr[i] to long
            }
            Arrays.sort(arr);

            long count = 0;  // Change count to long

            for (int i = 0; i < n; i++) {
                if (arr[i] < a) {
                    count += arr[i];
                } else if (arr[i] >= a) {
                    count += a - 1;
                }
            }
            count += b;
            System.out.println(count);
        }
    }
}
