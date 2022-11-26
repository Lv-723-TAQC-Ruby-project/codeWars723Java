package com.org.ita.kata.implementation.LypskyiOleksandr;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Five;

import java.math.BigInteger;

public class FiveImpl extends BaseKata implements Five {
    @Override
    public int artificialRain(int[] v) {
        int left = 0;
        int longestSection = 0;
        int currentSection = 1;
        for (int i = 1; i < v.length; i++) {
            if (v[i] < v[i - 1]) {
                left = i;
            } else if (v[i] > v[i - 1]) {
                longestSection = Math.max(longestSection, currentSection);
                currentSection = i - left;
            }
            currentSection += 1;
        }
        return Math.max(longestSection, currentSection);
    }

    @Override
    public long[] gap(int g, long m, long n) {
        return new long[0];
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
