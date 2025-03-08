package com.company.TLE12dotO.twoPointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class enduringExodus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();  // Consume the newline character
        String s = sc.nextLine();

        List<Integer> zeroIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeroIndices.add(i);
            }
        }

        int left = 0, right = k;  // Initial window size of k + 1 zeros
        int farmer = 0;
        int minMaxDistance = Integer.MAX_VALUE;

        while (right < zeroIndices.size()) {
            // Move farmer (median position) to minimize the maximum distance
            while (farmer < right &&
                    Math.max(zeroIndices.get(farmer) - zeroIndices.get(left),
                            zeroIndices.get(right) - zeroIndices.get(farmer)) >
                            Math.max(zeroIndices.get(farmer + 1) - zeroIndices.get(left),
                                    zeroIndices.get(right) - zeroIndices.get(farmer + 1))) {
                farmer++;
            }

            // Calculate the maximum distance for the current configuration
            int maxDistance = Math.max(zeroIndices.get(farmer) - zeroIndices.get(left),
                    zeroIndices.get(right) - zeroIndices.get(farmer));
            minMaxDistance = Math.min(minMaxDistance, maxDistance);
            left++;
            right++;
        }

        System.out.println(minMaxDistance);
    }
}
