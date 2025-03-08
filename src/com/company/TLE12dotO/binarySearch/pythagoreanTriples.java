package com.company.TLE12dotO.binarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pythagoreanTriples {


    static List<Long> v = new ArrayList<>();

    // Precompute the list of values
    static void pre() {
        long m = (long) 1e5;
        v.add(0L); // Adding 0 to the list initially
        for (long a = 3; a < m; a += 2) {
            long A = a * a;
            long b = A / 2, c = A / 2 + 1;
            if (b * b + a * a == c * c && A == b + c) {
                v.add(c);
            }
        }
    }

    public static void main(String[] args) {
        pre(); // Precompute values
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            solve(n);
        }

    }

    static void solve(int n) {
        // Find the upper bound using binary search
        int index = upperBound(v, n);
        System.out.println(index-1);
    }

    // Custom implementation of upper_bound
    static int upperBound(List<Long> list, long key) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // This gives the index of the first element greater than key
    }

}
