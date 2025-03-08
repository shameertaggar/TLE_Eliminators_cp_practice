package com.company.conceptPractice.bitMask;

import java.util.Scanner;

public class raisingBActeria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int c = 0;
        while (x > 0) {
            c += (x & 1);  // Increment count if the last bit is set
            x >>= 1;       // Right shift x by 1 to process the next bit
        }
        System.out.println(c);

    }


}
