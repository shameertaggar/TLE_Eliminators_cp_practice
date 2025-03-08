package com.company.TLE12dotO.binarySearch;



import java.util.Scanner;

public class multiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int start = 1;
        int end = n * n;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (check(n, mid) == 1) {
                System.out.println("not founded");
                start = mid + 1;
            } else {

                ans = mid;
                end = mid-1;
            }
        }
        System.out.println(ans);

    }

    private static int check(int n, int mid) {
        int count = 0;

        // Count how many numbers are less than or equal to 'mid'
        for (int i = 1; i <= n; i++) {
            // Count numbers in the i-th row that are <= mid
            count += Math.min(mid / i, n);
        }

        if (count >= (n * n + 1) / 2) {

            return 2;
        }
        return 1;

    }
}
