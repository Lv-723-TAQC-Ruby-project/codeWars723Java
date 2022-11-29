package com.org.ita.kata.implementation.KovalyovVladyslav;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Five;

import java.math.BigInteger;

public class FiveImpl extends BaseKata implements Five {
    @Override
    public int artificialRain(int[] v) {
        int field = 0;

        int numberOfField = v.length;
        int[] leftSide = new int[numberOfField];
        int[] rightSide = new int[numberOfField];

        for (int i = 1; i < numberOfField; i++) {
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
            field = Math.max(field, leftSide[i] + rightSide[i]);
        }
        return field + 1;
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

        for (long i = m; i + g <= n; i++) {
            if (isPrime(i) && isPrime(i + g) && gap(0, i + 1, i + g - 1) == null) {
                return new long[]{i, i + g};
            }
        }
        return null;
    }

    @Override
    public int zeros(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger second = BigInteger.ONE, first = second, num = second.add(first), sum = second;
        for(int i = 1; i <= n.intValue(); ++i) {
            second = first;
            first = num;
            num = num.add(second);
            sum = sum.add(second);
        }
        return sum.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solveSum(double m) {
        double s =  Math.sqrt(4 * m + 1);
        return (1 - s) / (2 * m) + 1;
    }

    @Override
    public long[] smallest(long n) {
        long smol = n;
        long delPos = 0;
        long insPos = 0;
        long tmpVal = 0;

        StringBuilder sb = new StringBuilder().append(n);
        int l = sb.length();

        for (int i = 0; i < l; i++) for (int j = 0; j < l; j++) {
            char c = sb.charAt(i);
            sb.deleteCharAt(i).insert(j, c);
            if ((tmpVal = Long.parseLong(sb.toString())) < smol) {
                smol = tmpVal;
                delPos = i;
                insPos = j;
            }
            sb.deleteCharAt(j).insert(i, c);
        }
        return new long[] {smol, delPos, insPos};
    }
}
