package com.company.conceptPractice.bitMask;

import java.util.Scanner;

public class roofConstruction {
    public static int maxPowerOfTwo(int n) {
        // Find the highest power of 2 less than or equal to n
        if (n < 1) return 0; // Handle non-positive input
        int power = 1;
        while (power <= n) {
            power <<= 1; // Multiply by 2 using left shift
        }
        return power >> 1; // Divide by 2 to get the largest power of 2 <= n
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            int smallestCost = maxPowerOfTwo(n);

            // Special case when n is a power of 2 itself
            if (smallestCost == n) {
                smallestCost /= 2;  // Use the next lower power of two for array placement
            }
            //System.out.println(smallestCost); // Printing the actual max power of 2 used

            for (int i = 0; i < smallestCost; i++) {
                arr[i] = i + 1;
            }
            arr[smallestCost] = smallestCost;
            arr[smallestCost - 1] = 0;
            for (int i = smallestCost+1; i<n; i++){
                arr[i] = i;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(); // Newline for next test case


        }
    }
}
