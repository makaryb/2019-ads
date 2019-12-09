package ru.mail.polis.ads.part9.makaryb;

import java.io.*;
import java.util.*;

/**
 * Made by БорискинМА
 * 09.12.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/6305104
 */
public final class FourthTask {
    private FourthTask() {}

    private static class E {
        int node;
        int w;

        E(int node, int w) {
            this.node = node;
            this.w = w;
        }

        int getWeight() {
            return w;
        }
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int sNode = in.nextInt();
        int fNode = in.nextInt();

        List<List<E>> graph = new ArrayList<>(n+1);
        PriorityQueue<E> priorityQueue =
                new PriorityQueue<>(Comparator.comparing(edge -> edge.getWeight()));
        List<Integer> ans = new ArrayList<>();

        int[] d = new int[n+1];
        int[] prev = new int[n+1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            d[i] = Integer.MAX_VALUE;
        }
        d[sNode] = 0;

        for (int i = 0; i < m; i++) {
            int startPoint = in.nextInt();
            int endPoint = in.nextInt();
            int w = in.nextInt();

            graph.get(startPoint).add(new E(endPoint, w));
            graph.get(endPoint).add(new E(startPoint, w));
        }
        priorityQueue.add(new E(sNode, 0));

        path(n, priorityQueue, graph, d, prev);

        out.println(d[fNode]);
        while (prev[fNode] != 0) {
            ans.add(0, fNode);
            fNode = prev[fNode];
        }
        ans.add(0, sNode);

        for (Integer a : ans) {
            out.print(a + " ");
        }

        out.flush();
    }

    private static void path(final int n, PriorityQueue<E> pQ, List<List<E>> g, int[] d, int[] prev) {
        boolean[] used = new boolean[n+1];

        while (!pQ.isEmpty()) {
            int currentNode = pQ.poll().node;

            if (used[currentNode]) {
                continue;
            }
            used[currentNode] = true;

            for (E node : g.get(currentNode)) {
                int startPoint = node.node;
                int w = node.w;

                if (d[startPoint] > d[currentNode] + w) {
                    d[startPoint] = d[currentNode] + w;
                    pQ.add(new E(startPoint, d[startPoint]));
                    prev[startPoint] = currentNode;
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
