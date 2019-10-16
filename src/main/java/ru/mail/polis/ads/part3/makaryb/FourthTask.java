package ru.mail.polis.ads.part3.makaryb;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

/**
 * Made by БорискинМА
 * 14.10.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * e-olymp 100%: https://www.e-olymp.com/ru/submissions/5851879
 */
public final class FourthTask {
    private FourthTask() {}

    private static void solve(final Scanner in, final PrintWriter out) {
        int search = in.nextInt();
        in.nextLine();

        StringTokenizer numbers = new StringTokenizer(in.nextLine());
        int n = numbers.countTokens();

        List<BigInteger> array = new Vector<>();

        for (int i = 0; i < n; i++) {
            array.add(new BigInteger(numbers.nextToken()));
        }

        search = array.size() - search;

        kthOrderStatistic(array, 0, array.size()-1, array.size()/2, search);

        out.println(array.get(search));

        out.flush();
    }

    // https://algorithmsandme.com/find-kth-smallest-element-in-array/
    private static void kthOrderStatistic(final List<BigInteger> array, int begin, int end, int mid, int index) {
        int i = begin;
        int j = end;
        BigInteger start = array.get(mid);
        while (i < j + 1) {
            while (array.get(i).compareTo(start) < 0) {
                i++;
            }
            while (array.get(j).compareTo(start) > 0) {
                j--;
            }

            if (i < j + 1) {
                BigInteger temp = array.get(j);
                array.set(j, array.get(i));
                array.set(i, temp);
                j--;
                i++;
            }
        }

        if (index < j+1) {
            end = j;
            kthOrderStatistic(array, begin, end, (end-begin)/2+begin,  index);
        }
        else if (index > i-1) {
            begin = i;
            kthOrderStatistic(array, begin, end, (end-begin)/2+begin,  index);
        }
    }

    public static void main(final String[] arg) {
        final Scanner in = new Scanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}
