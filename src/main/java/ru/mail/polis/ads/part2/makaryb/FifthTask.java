package ru.mail.polis.ads.part2.makaryb;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Made by БорискинМА
 * 05.10.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5784284
 */
public final class FifthTask {

    private static Stack<Integer> stack = new Stack<>();

    private FifthTask() {}

    private static void solve(final FastScanner in) {
        label:
        while(true) {
            String str = in.next();
            switch (str) {
                case "push":
                    pushStack(in);
                    break;
                case "pop":
                    popStack();
                    break;
                case "back":
                    backStack();
                    break;
                case "size":
                    sizeStack();
                    break;
                case "clear":
                    clearStack();
                    break;
                default:
                    System.out.println("bye");
                    break label;
            }
        }
    }

    private static void pushStack(final FastScanner in) {
        final int n = in.nextInt();
        stack.push(n);
        System.out.println("ok");
    }

    private static void popStack() {
        if (stack.isEmpty()) {
            System.out.println("error");
        }
        else {
            System.out.println(stack.pop());
        }
    }

    private static void backStack() {
        if (stack.isEmpty()) {
            System.out.println("error");
        }
        else {
            System.out.println(stack.peek());
        }
    }

    private static void sizeStack() {
        System.out.println(stack.size());
    }

    private static void clearStack() {
        stack.clear();
        System.out.println("ok");
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
