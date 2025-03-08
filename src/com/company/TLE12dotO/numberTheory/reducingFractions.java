package com.company.TLE12dotO.numberTheory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class reducingFractions {
    static final int N = 100000;
    static int[] smallestPrime = new int[N + 1];

    public static void main(String[] args) {
        initializeSmallestPrimes();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = readArray(sc, n);
        int[] brr = readArray(sc, m);

        HashMap<Integer, Integer> numFactors = factorizeArray(arr);
        HashMap<Integer, Integer> denFactors = factorizeArray(brr);

        HashMap<Integer, Integer> minPow = computeMinPower(numFactors, denFactors);
        reduceArrayWithFactors(arr, minPow);
        reduceArrayWithFactors(brr, minPow);

        printResult(arr, brr);
    }

    private static void initializeSmallestPrimes() {
        for (int i = 2; i <= N; i++) smallestPrime[i] = i;
        for (int i = 2; i * i <= N; i++) {
            if (smallestPrime[i] == i) {
                for (int j = i * i; j <= N; j += i) {
                    if (smallestPrime[j] == j) smallestPrime[j] = i;
                }
            }
        }
    }

    private static int[] readArray(Scanner sc, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    private static HashMap<Integer, Integer> factorizeArray(int[] array) {
        HashMap<Integer, Integer> factorMap = new HashMap<>();
        for (int num : array) {
            factorizeNumber(num, factorMap);
        }
        return factorMap;
    }

    private static void factorizeNumber(int num, HashMap<Integer, Integer> factorMap) {
        while (num > 1) {
            int prime = smallestPrime[num];
            int count = 0;
            while (num % prime == 0) {
                count++;
                num /= prime;
            }
            factorMap.put(prime, factorMap.getOrDefault(prime, 0) + count);
        }
    }

    private static HashMap<Integer, Integer> computeMinPower(HashMap<Integer, Integer> numFactors, HashMap<Integer, Integer> denFactors) {
        HashMap<Integer, Integer> minPow = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : numFactors.entrySet()) {
            int prime = entry.getKey();
            int numCount = entry.getValue();
            int denCount = denFactors.getOrDefault(prime, 0);
            minPow.put(prime, Math.min(numCount, denCount));
        }
        return minPow;
    }

    private static void reduceArrayWithFactors(int[] array, HashMap<Integer, Integer> factors) {
        for (int i = 0; i < array.length; i++) {
            array[i] = reduceNumber(array[i], factors);
        }
    }

    private static int reduceNumber(int num, HashMap<Integer, Integer> factors) {
        while (num > 1) {
            int prime = smallestPrime[num];
            int count = 0;
            while (num % prime == 0) {
                count++;
                num /= prime;
            }
            int factorCount = Math.min(count, factors.getOrDefault(prime, 0));
            factors.put(prime, factors.getOrDefault(prime, 0) - factorCount);
            num *= minPow(prime, count - factorCount);
        }
        return num;
    }

    private static int minPow(int base, int exp) {
        int result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result *= base;
            base *= base;
            exp >>= 1;
        }
        return result;
    }

    private static void printResult(int[] arr, int[] brr) {
        System.out.println(arr.length + " " + brr.length);
        for (int val : arr) System.out.print(val + " ");
        System.out.println();
        for (int val : brr) System.out.print(val + " ");
        System.out.println();
    }
}
