package com.company.TLE12dotO.twoPointers;

import java.util.Scanner;

public class minimizeTheInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String a = sc.next();

            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();

            // Separate digits into even and odd
            for (char ch : a.toCharArray()) {
                if ((ch - '0') % 2 == 0) {
                    even.append(ch);
                } else {
                    odd.append(ch);
                }
            }

            int p1 = 0;
            int p2 = 0;
            StringBuilder ans = new StringBuilder();

            // Merge the even and odd digits while maintaining sorted order
            while (p1 < even.length() && p2 < odd.length()) {
                if (even.charAt(p1) < odd.charAt(p2)) { // Corrected comparison logic
                    ans.append(even.charAt(p1));
                    p1++;
                } else {
                    ans.append(odd.charAt(p2));
                    p2++;
                }
            }

            // Append remaining digits
            while (p1 < even.length()) {
                ans.append(even.charAt(p1));
                p1++;
            }
            while (p2 < odd.length()) {
                ans.append(odd.charAt(p2));
                p2++;
            }

            System.out.println(ans.toString());
        }

        sc.close();
    }
}
