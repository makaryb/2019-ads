package ru.mail.polis.ads.part10.makaryb;

import java.io.*;
import java.util.*;

/**
 * Made by БорискинМА
 * 24.12.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/6407890
 */
public final class FourthTask {
    private FourthTask() {}

    private static int counter = 0;
    private static int setSize = 0;

    private static Set<Integer>[] set;
    private static ArrayList<Integer> stack;

    private static void solve(final FastScanner in, final PrintWriter out) {
        final int n = in.nextInt();
        final int m = in.nextInt();

        int[] colors = new int[n + 1];
        boolean[] used = new boolean[n + 1];
        set = new Set[n + 1];
        stack = new ArrayList<>(n + 1);

        List<Integer>[] graph = new List[n + 1];
        List<Integer>[] revGraph = new List[n + 1];

        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
            set[i] = new TreeSet<>();
        }
        for (int i = 1; i < m+1; i++) {
            int a = in.nextInt(), b = in.nextInt();
            graph[a].add(b);
            revGraph[b].add(a);
        }
        for (int i = 1; i < n+1; i++) {
            if (!used[i]) {
                dfs(i, graph, used, stack);
            }
        }
        for (int i = n - 1; i > -1; i--) {
            if (used[stack.get(i)]) {
                counter++;
                dfs(stack.get(i), revGraph, used, counter, colors);
            }
        }
        for (int i = 1; i < n+1; i++) {
            setSize += set[i].size();
        }

        out.println(setSize);
    }

    static void dfs(int vert, List<Integer>[] graph,
                    boolean[] used, ArrayList<Integer> stack) {
        used[vert] = true;
        for (Integer integer: graph[vert]) {
            if (!used[integer]) {
                dfs(integer, graph, used, stack);
            }
        }
        stack.add(vert);
    }

    static void dfs(int vert, List<Integer>[] revGraph,
                    boolean[] revUsed, int color, int[] colors) {
        revUsed[vert] = false;
        colors[vert] = color;
        for (Integer integer: revGraph[vert]) {
            if (revUsed[integer]) {
                dfs(integer, revGraph, revUsed, color, colors);
            } else if (colors[integer] != color) {
                set[color].add(colors[integer]);
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

