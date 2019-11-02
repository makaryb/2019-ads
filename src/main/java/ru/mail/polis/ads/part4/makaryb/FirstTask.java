package ru.mail.polis.ads.part4.makaryb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Made by БорискинМА
 * 19.10.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5897068
 */
public final class FirstTask {

    private static int max = 100010;
    private static long[] a = new long[max];
    @SuppressWarnings("FieldCanBeLocal")
    private static int i = 0;

    private FirstTask() {}

    private static void solve(final FastScanner in, final PrintWriter out) {
        final int n = Integer.parseInt(in.next());

        for (i = 1; i < n+1; i++) {
            a[i] = in.nextLong();
        }

        for (i = 1; i < n/2 + 1; i++) {
            if ((2*i < n+1) && (a[i] > a[2*i])) {
                break;
            }
            if ((2*i + 1 < n+1) && (a[i] > a[2*i + 1])) {
                break;
            }
        }

        if (i < n/2 + 1) {
            out.println("NO");
        }
        else {
            out.println("YES");
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
