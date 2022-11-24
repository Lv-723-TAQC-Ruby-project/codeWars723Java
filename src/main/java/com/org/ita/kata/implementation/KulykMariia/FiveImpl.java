package com.org.ita.kata.implementation.KulykMariia;

import com.org.ita.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    public static boolean isPrime(long n) {
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    @Override
    public int artificialRain(int[] garden) {
        int length = garden.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int result = 0;

        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return 1;
        }

        for (int i = 1; i < length; i++)
            if (garden[i - 1] <= garden[i]) {
                left[i] = left[i - 1] + 1;
            }

        for (int i = length - 2; i >= 0; i--)
            if (garden[i + 1] <= garden[i]) {
                right[i] = right[i + 1] + 1;
            }

        for (int i = 0; i < length; i++) {
            int currentSize = left[i] + right[i] + 1;
            if (currentSize > result)
                result = currentSize;
        }
        return result;
    }

    @Override
    public long[] gap(int g, long m, long n) {

        // g -> (integer >= 2) which indicates the gap we are looking for;
        // m -> (integer > 2) which gives the start of the search (m inclusive);
        // n -> (integer >= m) which gives the end of the search (n inclusive);

        long[] pair = new long[2];
        int k = 0;
        for (long i = m; i < n; i++) {
            k++;
            if (isPrime(i)) {
                if ((k == g) && (i - g >= m)) {
                    pair[0] = i - g;
                    pair[1] = i;
                    return pair;
                } else k = 0;
            }
        }
        return null;
    }

    @Override
    public int zeros(int n) {
        int s = 0;
        while (n > 4) {
            s += n / 5;
            n /= 5;
        }
        return s;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger a;
        BigInteger b = BigInteger.ONE;
        BigInteger count = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;

        for (int i = 0; i <= n.intValue(); i++) {
            a = b;
            b = count;
            count = a.add(b);
            sum = sum.add(a);
        }
        return sum.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solveSum(double m) {
        double b = -2 * m - 1;
        return (-b - Math.sqrt(Math.pow(b, 2) - 4 * m * m)) / (2 * m);
    }

    @Override
    public long[] smallest(long n) {
        String numberString = String.valueOf(n);
        char[] number = numberString.toCharArray();
        long[] output = {};

        for (int i1 = 0; i1 < number.length; i1++) {

            for (int i2 = 0; i2 < number.length; i2++) {
                StringBuilder digits = new StringBuilder();
                String x = String.valueOf(number[i1]);
                String result = String.valueOf(digits.insert(i2, x));
                String finalVal = String.valueOf(digits);

                while (Integer.parseInt(result) < Integer.parseInt(numberString)) {
                    output = new long[]{Integer.parseInt(finalVal), i1, i2};
                }
            }
        }
        return output;
    }
}

