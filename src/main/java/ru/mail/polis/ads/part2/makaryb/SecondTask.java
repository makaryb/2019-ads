package ru.mail.polis.ads.part2.makaryb;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 * Made by БорискинМА
 * 06.10.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5791360
 */
public final class SecondTask {

    private static int n = 0;
    private static int k = 0;
    private static int max = 1000;
    private static int min = 0;

    private static List<Integer> values = new Vector<>();

    private SecondTask() {}

    private static void solve(final Scanner in) {
        getValues(in);

        System.out.println(stairs());
    }

    private static void getValues(final Scanner in) {
        n = in.nextInt();

        if (n > max || n < min) {
            System.exit(1);
        }

        values.add(0);
        for (int i = 1; i < n+1; i++) {
            values.add(in.nextInt());
            if (values.get(i) > max || values.get(i) < -max) {
                System.exit(1);
            }
        }
        values.add(0);

        k = in.nextInt();

        if (k < min || k > n) {
            System.exit(1);
        }
    }

    private static int stairs() {
        int temp;
        int current;

        for (int i = 1; i < n+2; i++) {
            temp = Math.max(i-k, 0);
            current = values.get(i);
            values.set(i, values.get(i)+values.get(temp));
            for (int j = temp + 1; j < i; j++) {
                values.set(i, Math.max(values.get(i), values.get(j) + current));
            }
        }

        return values.get(n+1);
    }

    public static void main(final String[] arg) {
        final Scanner in = new Scanner(System.in);
        solve(in);
    }
}