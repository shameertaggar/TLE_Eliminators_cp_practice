package com.company.TLE12dotO.twoPointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class theyAreEveryWhere {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();
        Set<Character> uniqueChars = new HashSet<>();
        for (char ch : s.toCharArray()) uniqueChars.add(ch);

        int left = 0, right = 0;
        int minWindow = Integer.MAX_VALUE;

        while (right < n) {
            
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while (map.size() == uniqueChars.size()) {
                minWindow = Math.min(minWindow, right - left + 1);
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            right++;
        }

        System.out.println(minWindow);
    }
}
