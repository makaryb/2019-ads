package ru.mail.polis.ads.part3.makaryb;

import java.io.*;
import java.util.*;

/**
 * Made by БорискинМА
 * 13.10.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5847834
 */
public final class SecondTask {

    private SecondTask() {}

    private static void solve(final FastScanner in, final PrintWriter out) {
        final int n = in.nextInt();

        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            final int value = in.nextInt();
            array[i] = value;
        }

        Arrays.sort(array, (o1, o2) -> {
            if (o1 % 10 == o2 % 10) return o1 - o2;
            else return o1 % 10 - o2 % 10;
        });

        for (Integer integer : array) {
            out.print(integer+" ");
        }
        out.println();

        out.flush();
    }

    private static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}
