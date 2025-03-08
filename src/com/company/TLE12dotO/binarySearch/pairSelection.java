package com.company.TLE12dotO.binarySearch;

import java.io.*;
import java.util.*;

public class pairSelection {
    static PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
    static FastReader sc = new FastReader();
    public static int n;

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            double a[] = new double[n];
            double b[] = new double[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
            }

            double end = 1e6;
            double start = 0;
            double ans = 0;
            int it = 0;
            while (it < 50) {
                it++;
                double mid = start + (end - start) / 2;
                ArrayList<double[]> ta = new ArrayList<double[]>();
                transformedArray(ta, a, b, mid);
                if (checkBS(ta, k) >= mid) {
                    ans = mid;
                    start = mid;
                } else {
                    end = mid;
                }
            }
            pw.println(ans);
        }
        pw.close();
    }

    private static double checkBS(ArrayList<double[]> ta, int k) {
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < k; i++) {
            double l = ta.get(i)[1];
            double r = ta.get(i)[2];
            sum1 += l;
            sum2 += r;
        }
        double ans = sum1 / sum2;
        return ans;
    }

    private static void transformedArray(ArrayList<double[]> ta, double[] a, double[] b, double mid) {
        for (int i = 0; i < a.length; i++) {
            double temp = a[i] - mid * b[i];
            ta.add(new double[]{temp, a[i], b[i]});
        }
        // Using anonymous Comparator for sorting
        Collections.sort(ta, new Comparator<double[]>() {
            @Override
            public int compare(double[] d, double[] e) {
                return Double.compare(e[0], d[0]); // Sort in descending order by temp
            }
        });
    }

    // FastReader for efficient input handling
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
