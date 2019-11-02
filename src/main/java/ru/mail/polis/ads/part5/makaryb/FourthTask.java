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
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5962050
 */
public final class FourthTask {

    // does the WORD MATCH the PATTERN?
    private static boolean[][] WMP;

    private FourthTask() {}

    private static void solve(final FastScanner in, final PrintWriter out) {
        final String w = in.next();
        final String p = in.next();

        WMP = new boolean[w.length() + 1][p.length() + 1];

        out.println(checker(w, p));

        out.flush();
    }

    private static String checker(final String word, final String pattern) {
        WMP[0][0] = true;

        for (int i = 1; i < word.length() + 1; i++) {
            final char symbol1 = word.charAt(i - 1);

            for (int j = 1; j < pattern.length() + 1; j++) {
                final char symbol2 = pattern.charAt(j - 1);

                if (symbol1 == symbol2 || symbol1 == '?' || symbol2 == '?') {
                    WMP[i][j] = WMP[i - 1][j - 1];
                }
                else if (symbol1 == '*') {
                    WMP[i][j] = WMP[i - 1][j - 1] ||
                            WMP[i][j - 1] || WMP[i - 1][j];
                }
                else if (symbol2 == '*') {
                    WMP[i][j] = WMP[i - 1][j - 1] ||
                            WMP[i - 1][j] || WMP[i][j - 1];
                }
            }
        }

        return WMP[word.length()][pattern.length()] ? "YES" : "NO";
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
