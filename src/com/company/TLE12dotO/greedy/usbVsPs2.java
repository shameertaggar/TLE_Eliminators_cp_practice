package com.company.TLE12dotO.greedy;

import java.util.*;

import java.util.*;

public class usbVsPs2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of computers with different port types
        int a = sc.nextInt();  // Only USB ports
        int b = sc.nextInt();  // Only PS/2 ports
        int c = sc.nextInt();  // Both USB and PS/2 ports
        int m = sc.nextInt();  // Number of available mice

        List<Integer> usb = new ArrayList<>();
        List<Integer> ps2 = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int price = sc.nextInt();
            String type = sc.next(); // Read the type properly

            if (type.equals("USB")) {
                usb.add(price);
            } else {
                ps2.add(price);
            }
        }

        // Sort in ascending order (cheapest first)
        Collections.sort(usb);
        Collections.sort(ps2);

        int devices = 0;
        long cost = 0;

        // Use USB-only computers first
        for (int i = 0; i < a && i < usb.size(); i++) {
            cost += usb.get(i);
            devices++;
        }

        // Use PS/2-only computers
        for (int i = 0; i < b && i < ps2.size(); i++) {
            cost += ps2.get(i);
            devices++;
        }

        // Use universal computers with the cheapest available mice
        List<Integer> combined = new ArrayList<>();
        combined.addAll(usb.subList(Math.min(a, usb.size()), usb.size()));
        combined.addAll(ps2.subList(Math.min(b, ps2.size()), ps2.size()));

        Collections.sort(combined);
        for (int i = 0; i < c && i < combined.size(); i++) {
            cost += combined.get(i);
            devices++;
        }

        System.out.println(devices + " " + cost);
    }
}
