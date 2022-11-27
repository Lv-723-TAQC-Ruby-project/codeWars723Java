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
        if (n < 5) return 0;
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger totalSum = BigInteger.valueOf(0);
        BigInteger firstNum;
        BigInteger secondNum = BigInteger.valueOf(1);
        BigInteger thirdNum = BigInteger.valueOf(1);
        for (int i = 0; i <= n.intValue(); i++) {
            firstNum = secondNum;
            secondNum = thirdNum;
            thirdNum = firstNum.add(secondNum);
            totalSum = totalSum.add(firstNum);
        }
        return totalSum.multiply(BigInteger.valueOf(4));
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
