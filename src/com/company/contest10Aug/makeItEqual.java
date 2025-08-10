package com.company.contest10Aug;

import java.util.*;

public class makeItEqual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] s = new int[n];
            int[] tt = new int[n];

            for (int i = 0; i < n; i++) {
                s[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                tt[i] = sc.nextInt();
            }

            int[] fS = new int[n];
            int[] fT = new int[n];

            for (int i = 0; i < n; i++) {
                fS[i] = f(s[i], k);
                fT[i] = f(tt[i], k);
            }

            Arrays.sort(fS);
            Arrays.sort(fT);

            boolean possible = true;
            for (int i = 0; i < n; i++) {
                if (fS[i] != fT[i]) {
                    possible = false;
                    break;
                }
            }

            System.out.println(possible ? "YES" : "NO");
        }

        sc.close();
    }

    private static int f(int x, int k) {
        int r = x % k;
        return Math.min(r, (k - r) % k);
    }
}
