package com.company.DIV2B;

import java.util.Arrays;
import java.util.Scanner;

public class villagers {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            long arr[] = new long[n];   // changed to long[]

            for (int i = 0; i < n; i++){
                arr[i] = sc.nextLong(); // read as long
            }

            Arrays.sort(arr);
            int last = n - 1;
            int lastSec = n - 2;
            long cost = 0;   // changed to long

            while (lastSec >= 0){
                long n1 = arr[last];
                long n2 = arr[lastSec];
                cost += Math.max(n1, n2);
                long diff = Math.min(n1, n2);
                arr[last] -= diff;
                arr[lastSec] -= diff;
                last -= 2;
                lastSec -= 2;
            }

            if (lastSec == -1){

                cost += arr[0];
            }

            System.out.println(cost);
        }
    }
}

