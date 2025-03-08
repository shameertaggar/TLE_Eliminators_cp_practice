package com.company.cp31sheet.rating1200;

import java.util.Scanner;

public class scuza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            long arr[] = new long[n];
            arr[0] = sc.nextLong();
            for (int i = 1; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            long pref[] = new long[n + 1];
            long maxStep[] = new long[n];
            pref[0] = 0;
            pref[1] = arr[0];
            maxStep[0] = arr[0];
            for (int i = 1; i < n; i++) {
                pref[i + 1] = pref[i] + arr[i];
                maxStep[i] = Math.max(arr[i], maxStep[i - 1]);
            }
            long ques[] = new long[q];
            for (int i = 0; i < q; i++) {
                ques[i] = sc.nextLong();
            }

            long ans[] = new long[q];
            for (int i = 0; i < q; i++) {
                long k = ques[i];
                int start = 0;
                int end = n - 1;
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (maxStep[mid] <= k) {
                        ans[i] = pref[mid + 1];
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }

            for (int i = 0; i < q; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
