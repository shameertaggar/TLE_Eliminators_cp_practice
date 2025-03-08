package com.company.TLE12dotO.numberTheory;

public class euclideanAlgo {
    public static void main(String[] args) {
        int a = 6;
        int b = 57;
        int ans = gcd(a,b);
        System.out.println(ans);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b,a%b);
    }
}
