package ru.mail.polis.ads.part2.makaryb;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Made by БорискинМА
 * 05.10.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5783993
 */
public final class FourthTask {
    private FourthTask() {}

    private static void solve(final Scanner in) {
        String string = in.nextLine();

        int[] arr = stackWork(string);
        printResult(arr[0], arr[1]);
    }

    private static void printResult(final int open, final int flag) {
        if ((flag == 1) || (open > 0)) {
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
        }
    }

    private static int[] stackWork(final String string) {
        int[] arr = new int[2];
        for (int value : arr) {
            Arrays.fill(new int[]{value}, 0);
        }

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                arr[0]++;
            }
            else {
                arr[0]--;
            }
            if (arr[0] < 0) {
                arr[1] = 1;
                break;
            }
        }
        return arr;
    }

    public static void main(final String[] arg) {
        final Scanner in = new Scanner(System.in);
        solve(in);
    }
}
