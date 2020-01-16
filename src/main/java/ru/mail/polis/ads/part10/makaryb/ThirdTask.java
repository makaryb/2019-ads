package ru.mail.polis.ads.part10.makaryb;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Made by БорискинМА
 * 24.12.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 71%: https://www.e-olymp.com/ru/submissions/6407974
 */
public final class ThirdTask {
    private ThirdTask() {}

    private static int[] parent;

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        Queue<Edge> queue = new PriorityQueue<>(n, Comparator.comparing(edge -> edge.dangerousWay));
        Edge edge = null;

        parent = new int[n + 1];
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int firstId = in.nextInt();
            int secondId = in.nextInt();
            int weight = in.nextInt();
            queue.add(new Edge(firstId, secondId, weight));
        }
        for (int i = 0; i < m; i++) {
            edge = queue.poll();
            unionSet(edge.f, edge.s);
            if (findSet(1) ==  findSet(n)) {
                break;
            }
        }

        out.println(edge.dangerousWay);
    }

    private static void unionSet(int f, int s) {
        f = findSet(f);
        s = findSet(s);
        if (f != s) {
            parent[s] = f;
        }
    }

    private static int findSet(int link) {
        while (parent[link] != link) {
            parent[link] = parent[parent[link]];
            link = parent[link];
        }
        return link;
    }

    private static class Edge {
        private int f;
        private int s;
        private int dangerousWay;

        public Edge(int f, int s, int dangerousWay) {
            this.f = f;
            this.s = s;
            this.dangerousWay = dangerousWay;
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
