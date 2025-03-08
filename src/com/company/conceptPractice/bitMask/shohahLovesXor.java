package com.company.conceptPractice.bitMask;

import java.util.Scanner;

public class shohahLovesXor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int x = sc.nextInt();
            long m = sc.nextLong();

            int ans = 0;
            for (int y = 1; y<= 2*x && y <= m; y++){
                if (x==y) continue;
                int xy = x^y;
                if (x%xy == 0 || y %xy == 0) ans++;
            }
            System.out.println(ans);
        }
    }
}
