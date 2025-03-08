package com.company.virtualContests.C_problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class preparingForTheExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] excludedQuestions = new int[m];
            Set<Integer> set1 = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                set1.add(i);
            }

            for (int i = 0; i < m; i++) {
                excludedQuestions[i] = sc.nextInt();
            }

            int knwQ[] = new int[k];
            Set<Integer> knownQuestions = new HashSet<>();
            for (int i = 0; i < k; i++) {
                knwQ[i] = sc.nextInt();
                knownQuestions.add(knwQ[i]);
            }

            StringBuilder ans = new StringBuilder();
            if (set1.equals(knownQuestions)) {
                for (int i = 0; i < m; i++) {
                    ans.append('1');
                }
            }

           else  if (k < n - 1) {
                for (int i = 0; i < m; i++) {
                    ans.append('0');
                }
            }else{
                for (int i = 0; i < m; i++) {
                    if (knownQuestions.contains(excludedQuestions[i])) {
                        ans.append('0');
                    } else {
                        ans.append('1');
                    }
                }
            }



            System.out.print(ans.toString());
            System.out.println();
        }
    }

}
