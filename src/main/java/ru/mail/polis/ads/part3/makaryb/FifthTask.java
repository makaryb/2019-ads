package ru.mail.polis.ads.part3.makaryb;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Made by БорискинМА
 * 13.10.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5850412
 */
public final class FifthTask {
    private FifthTask() {}

    static class E implements Comparable<E> {
        final int primary, secondary, cursor;
        E(final int p, final int s, final int index) {
            this.primary = p; this.secondary = s; this.cursor = index;
        }

        @Override
        public int compareTo(E o) {
            int c = this.primary - o.primary;
            return c == 0 ? this.cursor - o.cursor : c;
        }
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        final int n = in.nextInt();
        E[] array = new E[n];

        for(int i = 0; i < n; i++) {
            array[i] = new E(in.nextInt(), in.nextInt(), i);
        }

        Arrays.sort(array);

        for(E pair : array) {
            out.println(pair.primary + " " + pair.secondary);
        }

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

