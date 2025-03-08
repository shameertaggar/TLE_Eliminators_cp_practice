package com.company.TLE12dotO.combinatorics;

public class nCr {
    static final int N = 100000; // Adjust N as needed
    static final int P = 1000000007; // Modulo value for large numbers
    static long[] fact = new long[N + 1];
    static long[] invFact = new long[N + 1];

    public static void calculate() {
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1] * i % P;
        }
        invFact[N] = modInverse(fact[N], P);
        for (int i = N - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % P;
        }
    }

    public static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % P * invFact[n - r] % P;
    }

    public static long modInverse(long a, int mod) {
        return power(a, mod - 2, mod); // Using Fermat's little theorem for mod inverse
    }

    public static long power(long base, int exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }


    public static void main(String[] args) {
        calculate();
        int n = 10, r = 3; // Example values
        System.out.println("C(" + n + ", " + r + ") = " + nCr(n, r));
    }
}
