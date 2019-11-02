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
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5906523
 */
public final class SixthTask {
    private SixthTask() {}

    private static int[] array;

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int q = in.nextInt();

        array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        for(int i = 0; i < q; i++) {
            int x = in.nextInt();

            if(binary(n-1,x)) {
                out.println("YES");
            }
            else {
                out.println("NO");
            }
        }

        out.flush();
    }


    private static boolean binary(int end, int x) {
        int begin = 0;

        while (begin < end) {
            int cursor = (begin + end) / 2;

            if (x > array[cursor]) {
                begin = cursor + 1;
            }
            else {
                end = cursor;
            }
        }

        return array[begin] == x;
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
