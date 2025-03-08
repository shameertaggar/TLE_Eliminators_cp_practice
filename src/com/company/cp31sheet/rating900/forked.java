package com.company.cp31sheet.rating900;

import java.awt.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class forked {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            // Read input for each test case
            int a = sc.nextInt();
            int b = sc.nextInt();
            int xK = sc.nextInt();
            int yK = sc.nextInt();
            int xQ = sc.nextInt();
            int yQ = sc.nextInt();

            Set<String> kingPositions = new HashSet<>();
            Set<String> queenPositions = new HashSet<>();

            // Calculate knight moves for the king
            int[] dx = {a, -a};
            int[] dy = {b, -b};
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    // King possible knight moves
                    int nxK = xK + dx[i];
                    int nyK = yK + dy[j];
                    kingPositions.add(nxK + " " + nyK);

                    nxK = xK + dx[j];
                    nyK = yK + dy[i];
                    kingPositions.add(nxK + " " + nyK);

                    // Queen possible knight moves
                    int nxQ = xQ + dx[i];
                    int nyQ = yQ + dy[j];
                    queenPositions.add(nxQ + " " + nyQ);

                    nxQ = xQ + dx[j];
                    nyQ = yQ + dy[i];
                    queenPositions.add(nxQ + " " + nyQ);
                }
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    // King possible knight moves
                    int nxK = xK + dy[i];
                    int nyK = yK + dx[j];
                    kingPositions.add(nxK + " " + nyK);

                    nxK = xK + dy[j];
                    nyK = yK + dx[i];
                    kingPositions.add(nxK + " " + nyK);

                    // Queen possible knight moves
                    int nxQ = xQ + dy[i];
                    int nyQ = yQ + dx[j];
                    queenPositions.add(nxQ + " " + nyQ);

                    nxQ = xQ + dy[j];
                    nyQ = yQ + dx[i];
                    queenPositions.add(nxQ + " " + nyQ);
                }
            }


            // Find common positions between king and queen knight moves
            kingPositions.retainAll(queenPositions);

            // Output the result: number of common positions
            System.out.println(kingPositions.size());
        }

        sc.close();
    }

}
