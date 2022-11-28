package com.org.ita.kata.implementation.KhudoBohdan;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Five;

import java.math.BigInteger;
import java.util.ArrayList;

public class FiveImpl extends BaseKata implements Five {
    @Override
    public int artificialRain(int[] v) {
        int sections = 0;

        int numberOfSections = v.length;
        int[] leftSide = new int[numberOfSections];
        int[] rightSide = new int[numberOfSections];

        for (int i = 1; i < numberOfSections; i++) {
            if (v[i] >= v[i - 1]) {
                leftSide[i] = leftSide[i - 1] + 1;
            } else {
                leftSide[i] = 0;
            }
        }

        for (int i = v.length - 2; i >= 0; i--) {
            if (v[i] >= v[i + 1]) {
                rightSide[i] = rightSide[i + 1] + 1;
            } else {
                rightSide[i] = 0;
            }
        }
        for (int i = 0; i < v.length; i++) {
            sections = Math.max(sections, leftSide[i] + rightSide[i]);
        }
        return sections + 1;
    }

    private static boolean isPrime(long i) {
        for (long j = 2; j < i / 2; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public long[] gap(int g, long m, long n) {
        long[] result = new long[2];
        for (long i = m; i < n - g; i++) {
            if (isPrime(i) && isPrime(i + g)) {
                boolean cleanGap = true;
                for (long j = i + 1; j < i + g; j++) {
                    if (isPrime(j)) {
                        cleanGap = false;
                    }
                }
                if (cleanGap) {
                    result[0] = i;
                    result[1] = i + g;
                    break;
                }
            }
        }
        if (result[0] == 0 && result[1] == 0) {
            return null;
        }

        return result;
    }

    @Override
    public int zeros(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }

    private static BigInteger fib(BigInteger n) {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        for (int i = 0; i < n.intValue(); i++) {
            BigInteger t = a;
            a = b;
            b = b.add(t);
        }
        return a;
    }

    private static BigInteger sum(BigInteger n) {
        BigInteger one = BigInteger.valueOf(1);
        BigInteger two = BigInteger.valueOf(2);
        return fib(n.add(two)).subtract(one);
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger one = BigInteger.valueOf(1);
        BigInteger four = BigInteger.valueOf(4);

        return sum(n.add(one)).multiply(four);
    }

    @Override
    public double solveSum(double m) {
        return (1 - Math.sqrt(4 * m + 1)) / (2 * m) + 1;
    }

    private static ArrayList<Character> arrayToArrayList(char[] arr) {
        ArrayList<Character> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            result.add(arr[i]);
        }
        return result;
    }
    private static String arrayListToString(ArrayList<Character> arrayList) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            result.append(arrayList.get(i));
        }
        return result.toString();
    }

    @Override
    public long[] smallest(long n) {
        long min = n;
        long f = 0, t = 0;
        String num = String.valueOf(n);

        for (int i = 0; i < num.length(); i++) {
            for (int j = 0; j < num.length(); j++) {
                char[] arr = num.toCharArray();
                ArrayList<Character> arrayList = arrayToArrayList(arr);
                char c = arr[i];
                arrayList.remove(i);
                arrayList.add(j, c);
                long number = Long.parseLong(arrayListToString(arrayList));
                if (number < min) {
                    min = number;
                    f = i;
                    t = j;
                }
            }
        }

        return new long[] {min, f, t};
    }
}
