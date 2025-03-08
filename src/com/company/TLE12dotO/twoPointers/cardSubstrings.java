package com.company.TLE12dotO.twoPointers;

import java.util.Scanner;

public class cardSubstrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        // Frequency array for cards
        int[] freq = new int[26];
        for (char ch : s2.toCharArray()) {
            freq[ch - 'a']++;
        }

        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {
            // Use one card for the current character
            freq[s1.charAt(right) - 'a']--;

            // If the current window is invalid, shrink it
            while (isInvalid(freq)) {
                freq[s1.charAt(left) - 'a']++;
                left++;
            }

            // Add the number of valid substrings ending at `right`
            ans += right - left + 1;
        }

        System.out.println(ans);
    }

    // Check if the current window is invalid (any character frequency < 0)
    private static boolean isInvalid(int[] freq) {
        for (int count : freq) {
            if (count < 0) return true;
        }
        return false;
    }
}
