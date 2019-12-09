package ru.mail.polis.ads.part9.makaryb;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Made by БорискинМА
 * 09.12.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/6305352
 */
public final class SecondTask {
    private SecondTask() {}

    // 1 - 'white', 0 - 'black', 2 - 'grey'

    private static void solve(final FastScanner in, final PrintWriter out) {
        final int n = in.nextInt();

        PriorityQueue<Integer>[] pQ = new PriorityQueue[n+1];
        Stack<Integer> stack = new Stack<>();

        int[] colors = new int[n + 1];
        int[] prev = new int[n + 1];

        for (int i = 1; i < n+1; i++) {
            pQ[i] = new PriorityQueue<>(8);
            colors[i] = 1;
            prev[i] = -1;
        }

        final int m = in.nextInt();

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            pQ[a].add(b);
            pQ[b].add(a);
        }

        int min = getMinGraphCycleNode(n, stack, pQ, colors, prev);

        if (min == n+1) {
            out.println("No");
        } else {
            out.println("Yes");
            out.println(min);
        }
    }

    private static int getMinGraphCycleNode(final int n, Stack<Integer> stack,
                                    PriorityQueue<Integer>[] pQ, int[] colors, int[] prev) {
        int BLACK = 0;
        int WHITE = 1;
        int GREY = 2;

        int min = n + 1;

        for (int i = 1; i < n+1; i++) {
            if (min < i+1) {
                break;
            }

            boolean hasCycle = false;
            if (colors[i] == WHITE) {
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                Integer current = stack.peek();

                if (colors[current] == Integer.MAX_VALUE) {
                    hasCycle = false;
                    min = Math.min(current, min);
                }
                colors[current] = GREY;

                boolean canContinue = false;
                while(!pQ[current].isEmpty()) {
                    if (hasCycle) {
                        break;
                    }

                    try {
                        int next = pQ[current].poll();

                        if (next == prev[current]) {
                            continue;
                        }

                        if (colors[next] == GREY) {
                            hasCycle = true;
                            colors[next] = Integer.MAX_VALUE;

                            break;
                        }

                        if (colors[next] == WHITE) {
                            prev[next] = current;
                            stack.push(next);
                            canContinue = true;

                            break;
                        }
                    } catch (NullPointerException ignored) {}
                }

                if (canContinue) {
                    continue;
                }

                if (hasCycle) {
                    min = Math.min(current, min);
                }

                if (colors[current] != WHITE) {
                    colors[current] = BLACK;
                    stack.pop();
                }
            }
        }
        return min;
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
