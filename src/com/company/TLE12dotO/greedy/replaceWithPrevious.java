package com.company.TLE12dotO.greedy;

import java.util.Scanner;

public class replaceWithPrevious {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            StringBuilder sb = new StringBuilder();
            if (k >= 26){
                for (int i = 0;i<n;i++){
                    sb.append('a');
                }
                System.out.println(sb.toString());
                continue;
            }

            int[] mapping = new int[26];
            for (int i = 0; i < 26; i++){
                mapping[i] = i;
            }
            int arr[] = {0};
            int curr = findMax(s,k,arr);
            for (int i = 0; i<=curr; i++){
                mapping[i] = 0;
            }
            k -= curr;
            int lastIndex = s.charAt(arr[0])-'a';
            for (int i = lastIndex; i>Math.max(lastIndex-k,0);i--){
                mapping[i] = Math.max(lastIndex-k,0);
            }


            for (int i = 0; i < n; i++){
                int orig = s.charAt(i) - 'a';
                if (s.charAt(i) <= (char)(curr + 'a')) {
                    sb.append('a');
                } else {
                    char ch = (char)(mapping[orig] + 'a');
                    sb.append(ch);
                }
            }
            System.out.println(sb.toString());
        }
        sc.close();
        }



    private static int findMax(String str, int k,int arr[]) {
        int maxSmallVal = 0;
        for (int i = 0; i < str.length(); i++){
            int val = str.charAt(i)-'a';
            if (val > k){
                arr[0] = i;
                break;
            }
            maxSmallVal = Math.max(val,maxSmallVal);
        }
        return maxSmallVal;
    }
}
