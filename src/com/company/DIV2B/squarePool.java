package com.company.DIV2B;

import java.util.Scanner;

public class squarePool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int s = sc.nextInt();

            int arr[][] = new int[n][4];
            for (int i = 0; i<n; i++){
                for (int j = 0; j< 4; j++){
                    arr[i][j] = sc.nextInt();
                }
            }


            int count = 0;
            for(int i = 0 ; i< n; i++){
                int dx = arr[i][0];
                int dy = arr[i][1];
                int x = arr[i][2];
                int y = arr[i][3];
                if((x+y == s && dy != dx) || (x == y && dy == dx)) count++;
            }

            System.out.println(count);
        }
    }
}
