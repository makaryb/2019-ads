package ru.mail.polis.ads.part10.makaryb;

import java.io.*;
import java.util.*;

/**
 * Made by БорискинМА
 * 24.12.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 88%: https://www.e-olymp.com/ru/submissions/6407783
 * https://www.e-olymp.com/ru/submissions/6407825
 */
public final class FirstTask {
    private FirstTask() {}

    private static boolean[] used;
    private static int[] fin;
    private static int[] fup;

    private static List<List<Edge>> graph;

    private static int counter;
    private static int timer;


    private static void solve(final FastScanner in, final PrintWriter out) {
        final int n = in.nextInt();
        final int m = in.nextInt();

        graph = new ArrayList<>();
        used = new boolean[m+1];
        Arrays.fill(used, false);
        fin = new int[n+1];
        fup = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
            fin[i] = 0;
            fup[i] = 0;
        }
        for (int i = 1; i < m+1; i++) {
            final int a = in.nextInt();
            final int b = in.nextInt();
            graph.get(a).add(new Edge(i, b));
            graph.get(b).add(new Edge(i, a));
        }

        counter = 0;

        bridgesSearcher(n);

        out.println(counter);
        for (int i = 1; i < m+1 && counter > 0; i++) {
            if (used[i]) {
                out.print(i + " ");
                counter--;
            }
        }
    }

    private static void bridgesSearcher(final int n) {
        timer = 0;
        for (int i = 1; i < n+1; i++) {
            if (fin[i] == 0) {
                dfs(i, -1);
            }
        }
    }

    private static void dfs(int v, int p) {
        fin[v] = fup[v] = ++timer;
        for (Edge edge : graph.get(v)) {
            if (edge.link == p)  {
                continue;
            }
            if (fin[edge.to] != 0) {
                fup[v] = Math.min(fup[v], fin[edge.to]);
            } else {
                dfs(edge.to, edge.link);
                fup[v] = Math.min(fup[v], fup[edge.to]);
            }
        }

        if (p != -1 && fup[v] == fin[v]) {
            counter++;
            used[p] = true;
        }
    }

    public static class Edge {
        private int link;
        private int to;

        public Edge(int link, int to) {
            this.link = link;
            this.to = to;
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
