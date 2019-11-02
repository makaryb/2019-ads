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
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5961400
 */
public final class FifthTask {

    private static int[] array;

    private FifthTask() {}

    private static void solve(final FastScanner in, final PrintWriter out) {
        final int n = in.nextInt();

        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        for (int value : array) {
            out.print(value + " ");
        }
        out.println();

        int index_paste = n - 1;

        while (index_paste != -1) {
            int min = 9;
            int paste_index = index_paste;

            for (int i = index_paste + 1; i < n; ++i) {
                if (array[i] > array[index_paste] && min > array[i]) {
                    min = array[i];
                    paste_index = i;
                }
            }

            if (index_paste == paste_index) {
                index_paste--;
            }
            else {
                int tmp = array[index_paste];
                array[index_paste] = array[paste_index];
                array[paste_index] = tmp;

                qSortImplementation(index_paste + 1, n - 1);

                index_paste = n - 1;

                for (int value : array) {
                    out.print(value + " ");
                }

                out.println();
            }
        }

        out.flush();
    }

    private static int[] swap(int w1, int w2) {
        int temp = w1;
        w1 = w2;
        w2 = temp;

        int[] res = new int[2];
        res[0] = w1;
        res[1] = w2;

        return res;
    }

    private static void qSortImplementation(int l, int r) {
        int i = l;
        int j = r;
        int key = array[(i+j) >> 1];
        while (i < j + 1) {
            while (array[i] < key) {
                i++;
            }
            while (array[j] > key) {
                j--;
            }

            if (i < j + 1) {
                int[] sorted = swap(array[i], array[j]);
                array[i] = sorted[0];
                array[j] = sorted[1];

                i++;
                j--;
            }
        }

        if (i < r) {
            qSortImplementation(i ,r);
        }
        if (j > l) {
            qSortImplementation(l, j);
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
