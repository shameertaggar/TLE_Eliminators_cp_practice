package com.company.conceptPractice.bitMask;

import java.util.Scanner;

public class specialNumbers {
    static int mod = 1000000000+7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            long ans = 0;
            long p = 1;
            for (int i = 0; i<31; i++){
                if((k&1) == 1){
                    ans = (ans + p)%mod;
                }
                 p = p*n %mod;
                k = k >> 1;
            }
            System.out.println(ans%mod);
        }
    }
}
