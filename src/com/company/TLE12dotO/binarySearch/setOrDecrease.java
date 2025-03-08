package com.company.TLE12dotO.binarySearch;

import java.util.*;

public class setOrDecrease {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // Size of the array
            long k = sc.nextLong(); // Maximum allowed sum
            int[] arr = new int[n];

            long totalSum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt(); // Input array
                totalSum += arr[i];
            }

            Arrays.sort(arr); // Sort the array

            long left = 0, right = (long) 1e10, answer = (long) 1e10;

            while (left <= right) {
                long mid = left + (right - left) / 2;

                if (isPossible(arr, k, totalSum, mid)) {
                    answer = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            System.out.println(answer);
        }

        sc.close();
    }

    private static boolean isPossible(int[] arr, long maxSum, long totalSum, long operations) {
       long sum = totalSum;
       totalSum -= arr[0];
       totalSum += (arr[0]-operations);
       if (totalSum <= maxSum) return true;
       totalSum = sum;
       totalSum -= arr[0];
       long ops2 = 0;

       for (int i = arr.length-1; i>0; i--){
           ops2++;
           long left = operations-ops2;
           if (left < 0) break;

           long ops1 = arr[0]-left;
           totalSum -= arr[i];
           long tempSum = totalSum + ops1;
           tempSum += ops1*ops2;
           if(tempSum<=maxSum){
               return true ;
           }
       }
       return false;
    }

}
