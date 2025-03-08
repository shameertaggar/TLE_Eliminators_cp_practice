package com.company.conceptPractice.bitMask;

import java.util.Scanner;

public class MakeitZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            if ((n&1) == 0){
                System.out.println(2);
                System.out.println(1 + " " + n);
                System.out.println(1 + " " + n);
            }else{
                System.out.println(4);
                System.out.println(2+ " " + n);
                System.out.println(2+ " " + n);
                System.out.println(1+ " "+2);
                System.out.println(1+ " "+2);


            }
        }
    }
}
