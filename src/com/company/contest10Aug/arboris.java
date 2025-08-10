package com.company.contest10Aug;

import java.util.*;

public class arboris {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            // Special case: diameter already 1
            if (n == 2) {
                System.out.println(0);
                continue;
            }

            int[] degree = new int[n + 1];
            int[] leafNeighborCount = new int[n + 1];
            int leafCount = 0;

            for (int i = 1; i <= n; i++) {
                degree[i] = adj.get(i).size();
                if (degree[i] == 1) {  // It's a leaf
                    leafCount++;
                    int neighbor = adj.get(i).get(0);  // only one neighbor
                    leafNeighborCount[neighbor]++;
                }
            }

            int maxLeafNeighbors = 0;
            for (int i = 1; i <= n; i++) {
                maxLeafNeighbors = Math.max(maxLeafNeighbors, leafNeighborCount[i]);
            }

            System.out.println(leafCount - maxLeafNeighbors);
        }

        sc.close();
    }
}

