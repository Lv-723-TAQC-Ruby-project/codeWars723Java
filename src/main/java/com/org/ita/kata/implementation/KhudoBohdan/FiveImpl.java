package com.org.ita.kata.implementation.KhudoBohdan;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Five;

import java.math.BigInteger;

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
        return 0;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        return null;
    }

    @Override
    public double solveSum(double m) {
        return 0;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
