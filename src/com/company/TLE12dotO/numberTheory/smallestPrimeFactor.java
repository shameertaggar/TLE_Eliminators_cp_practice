package com.company.TLE12dotO.numberTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Pair{
    int first;
    int second;

    Pair(int f, int s){
        this.first = f;
        this.second = s;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Same reference
        if (o == null || getClass() != o.getClass()) return false; // Different types
        Pair pair = (Pair) o;
        return first == pair.first && second == pair.second; // Compare field values
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second); // Hash code based on fields
    }
}
public class smallestPrimeFactor {

    public static void primeFactorization(int n, int spf[], List<Pair> ans){

        while (n != 1){
            int prime = spf[n];
            int cnt = 0;

            while (n%prime == 0){
                n /= prime;
                cnt++;
            }
            ans.add(new Pair(prime,cnt));
        }

    }
    public static void main(String[] args) {
        int maxN = 1000000;
        int isPrime[] = new int[maxN+1];
        Arrays.fill(isPrime,1);
        isPrime[0] = 0;
        isPrime[0] = 0;
        int spf[] = new int[maxN+1];
        Arrays.fill(spf,1000000000);

        for (int i = 2; i*i <= maxN; i++){
            if (isPrime[i] == 1){
                spf[i] = i;
                for (int j = i*i; j<=maxN; j += i){
                    isPrime[j] = i;
                    spf[j] = Math.min(spf[j], i);
                }
            }
        }

        List<Pair> ans = new ArrayList<>();
        primeFactorization(100003,spf,ans);
        int k = 0;
        for (int i = 0; i<ans.size(); i++){
            System.out.print("(" + ans.get(i).first + "," + ans.get(i).second + ")");
            k++;
            if (k == 15){
                System.out.println();
                k=0;
            }
        }

    }
}
