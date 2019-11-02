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
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5961659
 */
public final class ThirdTask {

    private static long[] array;
    private static long[] dp;

    private ThirdTask() {}

    private static void solve(final FastScanner in, final PrintWriter out) {
        final int N = in.nextInt();
        array = new long[N];

        for (int i = 0; i < N; i++) {
            array[i] = in.nextLong();
        }

        // длина наибольшей посл.крат. подпосл.,
        // заканчивающейся элементом i.
        dp = new long[N];

        // Т.о. рассматриваем все предыдущие j,
        // которые являются делителями i.
        // Выбираем среди них такое, чтобы dp[j] было максимально.
        // Выводим наибольшее значение из dp.
        out.println(lss(N));

        out.flush();
    }

    private static long lss(final int N) {
        long length = 1;

        for (int i = 0; i < N; i++) {
            long max = 0;

            for (int j = 0; j <i ; j++) {
                if (array[j] != 0 && array[i] % array[j] == 0 &&
                        dp[j] > max) {
                    max = dp[j];
                }
            }

            dp[i] = max+1;

            if (dp[i] > length){
                length = dp[i];
            }
        }

        return length;
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
