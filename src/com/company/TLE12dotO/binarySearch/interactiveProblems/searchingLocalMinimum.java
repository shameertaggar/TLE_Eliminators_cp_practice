package com.company.TLE12dotO.binarySearch.interactiveProblems;

import java.util.Scanner;

public class searchingLocalMinimum {
    static int[] ask(int ind, int n, Scanner sc) {
        int[] ans = new int[3];

        // Get the value at index ind-1
        if (ind - 1 > 0) {
            System.out.println("? " + (ind - 1));
            System.out.flush();
            ans[0] = sc.nextInt();
        } else {
            ans[0] = Integer.MAX_VALUE;
        }

        // Get the value at index ind
        System.out.println("? " + ind);
        System.out.flush();
        ans[1] = sc.nextInt();

        // Get the value at index ind+1
        if (ind + 1 <= n) {
            System.out.println("? " + (ind + 1));
            System.out.flush();

            ans[2] = sc.nextInt();
        } else {
            ans[2] = Integer.MAX_VALUE;
        }

        return ans;
    }

    // Function to announce the answer
    static void tell(int ind) {
        System.out.println("! " + ind);
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int low = 1, high = n;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Get the values at mid-1, mid, and mid+1
            int[] val = ask(mid, n, sc);

            // Check if mid is the minimum
            if (val[1] < val[2] && val[1] < val[0]) {
                ans = mid;
                break;
            } else if (val[1] < val[2] && val[1] > val[0]) {
                high = mid - 1; // Move to the left side
            } else {
                low = mid + 1; // Move to the right side
            }
        }

        // Output the answer
        tell(ans);

        sc.close();
    }

}
