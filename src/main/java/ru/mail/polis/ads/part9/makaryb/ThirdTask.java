package ru.mail.polis.ads.part9.makaryb;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Made by БорискинМА
 * 08.12.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/6304796
 */
public final class ThirdTask {

    private ThirdTask() {}

    private static class E {
        int x;
        int y;
        int w;

        E(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        int[] d = new int[n+1];
        Arrays.fill(d, 30000);
        d[1] = 0;

        E[] edge = new E[m];

        for (int i = 0; i < m; i++) {
            int startPoint = in.nextInt();
            int endPoint = in.nextInt();
            int weight = in.nextInt();
            // наше ребро
            edge[i] = new E(startPoint, endPoint, weight);
        }

        FordBellman(n, m, edge, d);

        for (int i = 1; i < n + 1; i++) {
            out.print(d[i] + " ");
        }
    }

    private static void FordBellman(final int n, final int m, E[] edge, int[] d) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (d[edge[j].x] < 30000 && d[edge[j].y] >
                        d[edge[j].x] + edge[j].w) {

                    d[edge[j].y] = d[edge[j].x] + edge[j].w;
                }

                if (d[edge[j].x] < 30000) {
                    d[edge[j].y] =
                            Math.min(d[edge[j].y],
                                    d[edge[j].x] + edge[j].w);
                }
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
