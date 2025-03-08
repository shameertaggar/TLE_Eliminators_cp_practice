package com.company.TLE12dotO.numberTheory;

import java.util.Arrays;
import java.util.Scanner;

public class commonDivisors {
    static int q = 1000001;
    static int[] f = new int[q];

    public static void main(String[] args) {
        Arrays.fill(f, 0);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input the numbers and update the frequency array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            f[arr[i]]++;
        }

        // Loop through numbers from q-1 down to 1
        for (int i = q - 1; i >= 1; i--) {
            int count = 0;

            // Count multiples of 'i'
            for (int j = i; j < q; j += i) {
                count += f[j];
            }

            // If more than one multiple exists, print 'i'
            if (count > 1) {
                System.out.println(i);
                break;
            }
        }

        sc.close();
    }
}
