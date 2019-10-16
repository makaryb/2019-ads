package ru.mail.polis.ads.part2.makaryb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Made by БорискинМА
 * 08.10.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 90%: https://www.e-olymp.com/ru/submissions/5811237 (последний тест не проходит)
 */

public final class ThirdTask {

    private ThirdTask() {}

    private static void solve(final FastScanner in) {
        final int t = in.nextInt();

        getResult(in, t);
    }

    private static void getResult(final FastScanner in, final int t) {
        StringBuffer resultString = new StringBuffer();
        for (int i = 0; i < t; i++) {
            String inputString = in.next();
            final int len = inputString.length();

            List<String> result = new Vector<>() {{
                for (int k = 0; k < len+1; k++) {
                    add("");
                }
            }};

            tree(inputString, len-1, 0, result);

            for (int j = len-1; j > -1; j--) {
                resultString.append(result.get(j));
            }
            resultString.append("\n");
        }
        System.out.print(resultString);
    }

    private static int tree(final String input, final int index, final int depth, List<String> res) {
        int cursor = index;
        if (res.get(depth) != null) {
            res.set(depth, res.get(depth) + input.charAt(cursor));
        }
        else {
            res.set(depth, String.valueOf(input.charAt(cursor)));
        }

        cursor--;

        if (Character.isUpperCase(input.charAt(cursor+1))) {
            cursor = tree(input, cursor, depth + 1, res);
            cursor = tree(input, cursor, depth + 1, res);
        }
        return cursor;
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
        solve(in);
    }
}
