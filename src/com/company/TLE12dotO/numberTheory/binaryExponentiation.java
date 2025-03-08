package com.company.TLE12dotO.numberTheory;

public class binaryExponentiation {
    public static void main(String[] args) {
        int a = 2;
        int b = 23;

        int ans = binaryExp(a,b);
        System.out.println(ans);
    }

    private static int binaryExp(int a, int b) {
        int res = 1;
        while (b > 0){
            if ((b&1) == 1){
                res = res*a;
            }
            a = a*a;
            b >>= 1;
        }
        return res;
    }
}
