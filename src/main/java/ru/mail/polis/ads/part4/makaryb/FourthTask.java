package ru.mail.polis.ads.part4.makaryb;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Made by БорискинМА
 * 20.10.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5907784
 */
public final class FourthTask {

    private static int[] A;

    private static int result = 0;

    private FourthTask() {}

    private static void solve(final FastScanner in, final PrintWriter out) {
        final int n = in.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }

        mergeSearch(0, n-1);
        out.println(result);

        out.flush();
    }

    private static void mergeSearch(int l, int r) {
        if (l > r-1) {
            return;
        }

        int cursor = l + (r - l)/2;

        mergeSearch(l, cursor);
        mergeSearch(cursor+1, r);

        final int n = r - l;

        int[] couple = new int[n+1];
        System.arraycopy(A, l, couple, 0, n+1);

        int begin = 0;
        int end = n/2 + 1;

        for (int i = l; i < r+1; i++) {
            if (begin > n/2) {
                A[i] = couple[end++];
            }
            else if (end > n) {
                A[i] = couple[begin++];
            }
            else if (couple[end] < couple[begin]) {
                result += n/2 - begin + 1;

                A[i] = couple[end++];
            }
            else {
                A[i] = couple[begin++];
            }
        }
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
