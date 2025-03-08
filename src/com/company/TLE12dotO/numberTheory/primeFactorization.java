package com.company.TLE12dotO.numberTheory;

import java.util.ArrayList;
import java.util.List;

public class primeFactorization {

    public static void primeFactors(int n, List<Integer> primes){
        for (int i = 2; i*i <= n; i++){
            if (n%i == 0){
                primes.add(i);
                while (n%i == 0){
                    n /= i;
                }
            }
        }

        if (n > 1) {
            primes.add(n);
        }
    }
    public static void main(String[] args) {
        int n = 12382392;
        List<Integer> list = new ArrayList<>();
        primeFactors(n,list);
        System.out.println(list);
    }
}
