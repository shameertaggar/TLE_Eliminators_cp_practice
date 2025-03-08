package com.company.TLE12dotO.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class doubleLexicographicalMinimum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();  // Consume newline character after nextInt()

        while (t-- > 0){
            String s = sc.nextLine();
            char str[] = s.toCharArray();
            Arrays.sort(str);  // Sort the string in lexicographical order

            int i = 0;
            int j = str.length - 1;
            char ans[] = new char[str.length];
            int k = 0;

            while (i < j) {
                ans[j] = str[k++];
                ans[i] = str[k++];

                i++;
                j--;
            }

            // Handle the case where the string has an odd length
            if (i == j) {
                ans[i] = str[k];
            }

            // Convert ans to string and print it
            String result = new String(ans);
            System.out.println(result);
        }
    }
}

