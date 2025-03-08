package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final long MOD1 = 998244353;

    static int f(List<Integer> a) {
        int n = a.size();
        long[][][] dp = new long[n + 1][n + 1][2]; // Use long to avoid overflow
        dp[0][0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int liars = 0; liars <= i; liars++) {
                for (int p = 0; p < 2; p++) {
                    if (dp[i][liars][p] == 0) continue;

                    if (liars == a.get(i)) {
                        dp[i + 1][liars][0] = (dp[i + 1][liars][0] + dp[i][liars][p]) % MOD1;
                    }

                    if (p == 0) {
                        dp[i + 1][liars + 1][1] = (dp[i + 1][liars + 1][1] + dp[i][liars][p]) % MOD1;
                    }
                }
            }
        }

        long result = 0;
        for (int i = 0; i <= n; i++) {
            for (int last = 0; last < 2; last++) {
                result = (result + dp[n][i][last]) % MOD1;
            }
        }

        return (int) result; // Cast back to int as the result must be within int range
    }

    static void processInput() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            v.add(scanner.nextInt());
        }
        System.out.println(f(v));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            processInput();
        }
        scanner.close();
    }
}
