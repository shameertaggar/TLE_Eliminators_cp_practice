package com.company.conceptPractice.greedyMathNumberTheory;

import java.util.Scanner;

public class maximumGCD {

    public  static int maxGcd(int a, int b){
        if(b== 0) return a;
        return maxGcd(b,a%b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int gcd = 1;
            if ((n&1) == 0){
                gcd = maxGcd(n,n/2);
            }else{
                gcd = maxGcd(n-1,n/2);
            }
            System.out.println(gcd);
//            int a = -1;
//            int b= -1;
//            int ans = 0;
//            for (int i = 1; i <= n; i++){
//                for (int j = i+1; j <= n; j++){
//                    int gcd = maxGcd(i,j);
//
//                    if (gcd > ans){
//                        a = i;
//                        b = j;
//                        ans = gcd;
//                    }
//                }
//            }

         //   System.out.println("Ans : " +ans + "  a:" + a+ "  b:" + b);
        }
    }
}

//Ans : 5  a:5  b:10
//