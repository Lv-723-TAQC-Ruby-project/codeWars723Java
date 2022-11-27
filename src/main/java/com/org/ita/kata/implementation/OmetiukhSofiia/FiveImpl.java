package com.org.ita.kata.implementation.OmetiukhSofiia;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Five;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class FiveImpl extends BaseKata implements Five {
    @Override
    public int artificialRain(int[] v) {
        return 0;
    }

    @Override
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    @Override
    public int zeros(int n) {
        if (n < 0)
            return -1;
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        return Stream.iterate(new BigInteger[]{ZERO, ONE}, s -> new BigInteger[]{s[1], s[0].add(s[1])})
                .limit(n.intValue() + 1)
                .map(s -> s[1])
                .reduce(ZERO, BigInteger::add)
                .multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solveSum(double m) {
        double f = Math.sqrt(4 * m + 1);
        double result = (2 * m + 1 - f) / (2 * m);
        return result;
    }

    @Override
    public long[] smallest(long n) {

        return new long[0];
    }
}
