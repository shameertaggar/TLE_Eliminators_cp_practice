package com.company.TLE12dotO.numberTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class modulaEquations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a  = sc.nextInt();
        int b = sc.nextInt();
        if (a < b){
            System.out.println(0);
            return;
        }
        if (a==b){
            System.out.println("infinity");
            return;
        }
        int fx = a-b;
        int cnt = 0;
        for (int i = 1; i*i<= fx; i++){
            if (fx%i==0){
                if (i > b) cnt++;
                if (fx/i > b && fx/i != i)cnt++;
            }
        }
        System.out.println(cnt);

    }
}
