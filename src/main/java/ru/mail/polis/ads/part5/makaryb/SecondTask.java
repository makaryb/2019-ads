package ru.mail.polis.ads.part5.makaryb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Made by БорискинМА
 * 27.10.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5961477
 */
public final class SecondTask {
    private SecondTask() {}

    private static void solve(final FastScanner in, final PrintWriter out) {
        final long w = in.nextLong();
        final long h = in.nextLong();
        final long n = in.nextLong();

        final long l = Math.max(w, h);

        out.println(binary(l, n * l, w, h, n));
    }

    private static long binary(final long left, final long right,
                               final long width, final long height, final long n) {
        long begin = left;
        long end = right;

        while (begin < end) {
            long m = (begin + end) / 2;
            long v = (m / width) * (m / height);

            if (v > n-1) {
                end = m;
            }
            else {
                begin = m+1;
            }
        }
        return end;
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}
