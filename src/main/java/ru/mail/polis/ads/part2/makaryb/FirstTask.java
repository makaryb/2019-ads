package ru.mail.polis.ads.part2.makaryb;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Made by БорискинМА
 * 04.10.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5779738
 */
public final class FirstTask {
    private FirstTask() {}

    private static final int max = 102;
    // на плитке с координатами (i, j) будет находиться corns[i][j] зернышек.
    private static int[][] corns = new int[max][max];
    // маршрут движения мышки. Имеет размер (P-2)/2, где P - периметр пола по плиткам.
    private static StringBuilder ans = new StringBuilder("");

    private static void solve(final Scanner in) {
        final int w = in.nextInt();
        final int h = in.nextInt();

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                Arrays.fill(new int[]{corns[i][j]}, -1);
            }
        }

        for (int i = w-1; i >= 0; i--) {
            for (int j = 0; j < h; j++) {
                corns[i][j] = in.nextInt();
            }
        }

        setMaxCorns(w, h);
        setRoute(w, h);
    }

    private static void setMaxCorns(final int w, final int h) {
        for (int i = 1; i < w; i++) {
            corns[i][0] = corns[i][0] + corns[i - 1][0];
        }
        for (int j = 1; j < h; j++) {
            corns[0][j] = corns[0][j] + corns[0][j-1];
        }
        for (int i = 1; i < w; i++) {
            for (int j=1; j < h; j++) {
                corns[i][j] = corns[i][j] + Math.max(corns[i - 1][j], corns[i][j - 1]);
            }
        }
    }

    private static void setRoute(final int w, final int h) {
        int i = w - 1;
        int j = h - 1;
        while (i > 0 || j > 0) {
            if (i > 0 && j > 0) {
                if (corns[i-1][j] > corns[i][j-1]) {
                    ans.append("F");
                    i--;
                }
                else {
                    ans.append("R");
                    j--;
                }
            }
            else if (i == 0) {
                ans.append("R");
                j--;
            }
            else if (j == 0) {
                ans.append("F");
                i--;
            }
        }
        String reverse = new StringBuffer(ans.toString()).reverse().toString();
        System.out.println(reverse);
    }

    public static void main(final String[] arg) {
        final Scanner in = new Scanner(System.in);
        solve(in);
    }
}
