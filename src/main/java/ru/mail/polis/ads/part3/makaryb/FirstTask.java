package ru.mail.polis.ads.part3.makaryb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Made by БорискинМА
 * 11.10.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5834045
 */
public final class FirstTask {

    private FirstTask() {}

    private static void solve(final FastScanner in) {
        final int n = in.nextInt();
        int[] correct = new int[n];

        for (int i = 0; i < n; i++) {
            correct[i] = in.nextInt();
        }

        sort(correct, 0, n-1);

        for (int j = 0; j < n-1; j++) {
            System.out.print(correct[j]+" ");
        }
        System.out.println(correct[n-1]);
    }

    private static void merge(int[] correct, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int [n1];
        int[] R = new int [n2];

        System.arraycopy(correct, l + 0, L, 0, n1);
        System.arraycopy(correct, m + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                correct[k] = L[i];
                i++;
            }
            else {
                correct[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            correct[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            correct[k] = R[j];
            j++;
            k++;
        }
    }

    private static void sort(int[] correct, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            sort(correct, l, m);
            sort(correct, m+1, r);
            merge(correct, l, m, r);
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
        solve(in);
    }
}
