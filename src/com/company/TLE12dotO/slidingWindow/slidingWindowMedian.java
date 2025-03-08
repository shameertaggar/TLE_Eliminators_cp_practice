package com.company.TLE12dotO.slidingWindow;

import java.util.*;
import java.util.function.Supplier;

public class slidingWindowMedian {



    public static double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<>(comparator);

        // Lambda to calculate the median based on window size being odd or even
        Supplier<Double> median = (k % 2 == 0) ?
                () -> ((double) nums[left.first()] + nums[right.first()]) / 2 :
                () -> (double) nums[right.first()];

        // Balancing function to ensure that left and right sets are of correct sizes
        Runnable balance = () -> { while (left.size() > right.size()) right.add(left.pollFirst()); };

        double[] result = new double[nums.length - k + 1];

        // Initialize the left set with the first 'k' elements and balance them
        for (int i = 0; i < k; i++) left.add(i);
        balance.run();
        result[0] = median.get();

        // Slide the window and compute the median for each position
        for (int i = k, r = 1; i < nums.length; i++, r++) {
            // Remove the element that's sliding out of the window
            if (!left.remove(i - k)) right.remove(i - k);

            // Add the new element, which will always go to the right set first
            right.add(i);
            left.add(right.pollFirst());

            // Rebalance the sets and calculate the median
            balance.run();
            result[r] = median.get();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        double[] ans = medianSlidingWindow(nums, k);
        StringBuilder sb = new StringBuilder();
        for (double median : ans) {
            sb.append(median).append(" ");
        }
        String str =sb.toString();
        System.out.println(str);
    }
}
