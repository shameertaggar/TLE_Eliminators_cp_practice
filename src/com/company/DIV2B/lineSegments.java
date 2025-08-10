package com.company.DIV2B;

import java.util.Scanner;

public class lineSegments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();

            // Read the coordinates
            double px = sc.nextDouble();
            double py = sc.nextDouble();
            double qx = sc.nextDouble();
            double qy = sc.nextDouble();

            // Read distances
            double[] steps = new double[n];
            double totalSteps = 0;
            for (int i = 0; i < n; i++) {
                steps[i] = sc.nextDouble();
                totalSteps += steps[i];
            }

            // Calculate straight-line Euclidean distance between p and q

            double dx = px - qx;
            double dy = py - qy;
            double targetDistance = Math.sqrt(dx * dx + dy * dy);
            totalSteps += targetDistance;
            // Use precision threshold for floating point comparison
            if (targetDistance > totalSteps - targetDistance){
                System.out.println("No");
                continue;
            }

            boolean possible = true;
            for (int i = 0; i< n; i++){
                if (steps[i] > totalSteps-steps[i]){
                    possible = false;
                    break;
                }
            }
            if (possible)System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
