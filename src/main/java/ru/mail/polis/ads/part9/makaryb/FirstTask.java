package ru.mail.polis.ads.part9.makaryb;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Made by БорискинМА
 * 08.12.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/6304171
 */
public final class FirstTask {
    private static int[] prev;
    private static int checker = 0;

    private static ArrayList<ArrayList<Integer>> graph;
    private static ArrayList<Integer> head = new ArrayList<>();

    private FirstTask() {}

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        graph = new ArrayList<>();
        prev = new int[n +1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }

        for(int i = 1; i <= n; i++) {
            if (prev[i] == 0) dfs(i);
        }

        if (checker == 1) {
            out.println("-1");
        } else {
            for(int i = head.size() - 1; i >= 0; i--) {
                out.print(head.get(i) + " ");
            }
            out.print("\n");
        }
    }

    private static void dfs(int v) {
        prev[v] = 1;
        for(int i = 0; i < graph.get(v).size(); i++) {
            int to = graph.get(v).get(i);
            if (prev[to] == 1) {
                checker = 1;
            }
            if (prev[to] == 0) {
                dfs(to);
            }
        }

        prev[v] = 2;
        head.add(v);
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
