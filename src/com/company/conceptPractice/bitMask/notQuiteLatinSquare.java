package com.company.conceptPractice.bitMask;

import java.util.Scanner;

public class notQuiteLatinSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Number of test cases
        int xorABC = 'A' ^ 'B' ^ 'C';  // Precompute XOR of 'A', 'B', 'C'

        while (t-- > 0) {
            char[][] square = new char[3][3];
            int questionRow = -1, questionCol = -1;

            // Read input and find the position of '?'
            for (int i = 0; i < 3; i++) {
                String line = sc.next();
                for (int j = 0; j < 3; j++) {
                    square[i][j] = line.charAt(j);
                    if (square[i][j] == '?') {
                        questionRow = i;
                        questionCol = j;
                    }
                }
            }

            // Find the missing character
            char missing = 'a';
            for (int i = 0; i <3; i++){

                 missing = (char) (xorABC^(square[questionRow][0] ^ square[questionRow][1] ^ square[questionRow][2]^square[questionRow][questionCol]));
            }

            System.out.println(missing);
        }
        sc.close();
    }
}
