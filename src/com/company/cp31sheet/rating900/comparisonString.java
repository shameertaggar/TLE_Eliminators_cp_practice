package com.company.cp31sheet.rating900;

import java.util.Scanner;

public class comparisonString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            int cost = 1;
            int ans = 1;
            for (int i = 1; i<n; i++){
                if (s.charAt(i) == s.charAt(i-1)) cost++;
                else cost = 1;
                ans = Math.max(Math.abs(cost),ans);
            }
            System.out.println(ans+1);
        }
    }
}
