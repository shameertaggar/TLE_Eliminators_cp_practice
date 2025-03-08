package com.company.TLE12dotO.combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class luckyNumbers {
    static int[] segTree;
    static int[] arr;
    static int n;

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            String[] input = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            segTree = new int[4 * n];
            build(1, 0, n - 1, 0);

            int q = Integer.parseInt(br.readLine());
            while (q-- > 0) {
                String[] query = br.readLine().split(" ");
                int p = Integer.parseInt(query[0]) - 1;
                int x = Integer.parseInt(query[1]);
                arr[p] = x;
                update(1, 0, n - 1, p, 0);
                sb.append(segTree[1]).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void build(int node, int start, int end, int level) {
        if (start == end) {
            segTree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(2 * node, start, mid, level + 1);
            build(2 * node + 1, mid + 1, end, level + 1);
            if (level % 2 == 0) {
                segTree[node] = segTree[2 * node] | segTree[2 * node + 1];
            } else {
                segTree[node] = segTree[2 * node] & segTree[2 * node + 1];
            }
        }
    }

    static void update(int node, int start, int end, int idx, int level) {
        if (start == end) {
            segTree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(2 * node, start, mid, idx, level + 1);
            } else {
                update(2 * node + 1, mid + 1, end, idx, level + 1);
            }
            if (level % 2 == 0) {
                segTree[node] = segTree[2 * node] | segTree[2 * node + 1];
            } else {
                segTree[node] = segTree[2 * node] & segTree[2 * node + 1];
            }
        }
    }
}






