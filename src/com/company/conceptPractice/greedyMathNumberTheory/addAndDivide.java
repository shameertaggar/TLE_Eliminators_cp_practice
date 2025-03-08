package com.company.conceptPractice.greedyMathNumberTheory;

import java.util.Scanner;

public class addAndDivide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();

            int minOperations = Integer.MAX_VALUE;  // Initialize with a large value

            // Special case: if b == 1, we must increase it at least once to avoid infinite division
            int initialB = (b == 1) ? b + 1 : b;
            int extraSteps = (b == 1) ? 1 : 0;

            for (int increment = 0; increment <= 50; increment++) {
                int currentB = initialB + increment;
                int currentA = a;
                int steps = extraSteps + increment;  // Start counting the extra steps

                // Perform division steps until currentA becomes 0
                while (currentA > 0) {
                    currentA /= currentB;
                    steps++;
                }

                minOperations = Math.min(minOperations, steps);
            }

            System.out.println(minOperations);

        }
    }
}
//1 2 3 4 5 6 7 8