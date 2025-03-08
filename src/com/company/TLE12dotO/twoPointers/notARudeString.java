package com.company.TLE12dotO.twoPointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class notARudeString {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        String s = br.readLine();

        char[] str = s.toCharArray();
        int left = 0, right = 0;
        long a = 0, b = 0, curr = 0;
        int ans = 0;

        while (right < n) {
            a += (str[right] == 'a') ? 1 : 0;
            b += (str[right] == 'b') ? 1 : 0;
            if (str[right] == 'b') curr += a;

            while (curr > c) {
                a -= (str[left] == 'a') ? 1 : 0;
                b -= (str[left] == 'b') ? 1 : 0;
                if (str[left] == 'a') curr -= b;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }

        pw.println(ans);
        pw.flush();
    }
}
