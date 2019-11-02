package ru.mail.polis.ads.part4.makaryb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Made by БорискинМА
 * 20.10.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5940796
 */
public final class SeventhTask {

    private static int l = 0;
    private static int r = 0;
    private static int res = 0;

    private static int max = 10001;

    private static int[] array = new int[max];

    private SeventhTask() {}

    private static void solve(final FastScanner in, final PrintWriter out) {
        final int n = in.nextInt();
        final int k = in.nextInt();
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
            if (array[i] > r) {
                r = array[i];
            }
        }

        while (l < r) {
            int m = (l + r + 1) >> 1;
            int counter = 1;
            int cursor = array[0];

            for (int j = 1; j < n; j++) {
                if (!((array[j] - cursor) < m)) {
                    cursor = array[j];
                    counter++;
                }
            }

            if (counter > k-1) {
                l = m;
                res = m;
            }
            else {
                r = m - 1;
            }
        }

        out.println(res);
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
