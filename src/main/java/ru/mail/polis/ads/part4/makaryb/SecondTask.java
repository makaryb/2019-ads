package ru.mail.polis.ads.part4.makaryb;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Made by БорискинМА
 * 19.10.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5897167
 */
public final class SecondTask {
    private SecondTask() {}

    private static void solve(final FastScanner in, final PrintWriter out) {
        int N = in.nextInt();

        // https://www.geeksforgeeks.org/priority-queue-class-in-java-2/
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(N, (o1, o2) -> o2 - o1);

        while(N-- > 0) {
            if(in.nextInt() == 0) {
                pQueue.add(in.nextInt());
            }
            else {
                out.println(pQueue.poll());
            }
        }

        out.flush();
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
