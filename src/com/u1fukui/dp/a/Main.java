package com.u1fukui.dp.a;

// https://atcoder.jp/contests/dp/tasks/dp_a

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }

        int[] dp = createArray(n, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i -1] + Math.abs(h[i] - h[i - 1]);
            if (i > 1) {
                dp[i] = Math.min(dp[i], dp[i -2] + Math.abs(h[i] - h[i -2]));
            }
        }

        System.out.println(dp[n - 1]);
    }

    private static int[] createArray(int size, int defaultValue) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = defaultValue;
        }
        return array;
    }
}
