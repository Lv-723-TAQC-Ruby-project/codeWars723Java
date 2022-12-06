package com.org.ita.kata.implementation.StanislavKovalov;

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
        String s = Long.toString(n), tmp = s; long [] mem = new long[] {-1, -1, -1};
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            String str1 = s.substring(0, i) + s.substring(i+1, l);
            for (int j = 0; j < l; j++) {
                String str2 = str1.substring(0, j) + c + str1.substring(j);
                int cmp = str2.compareTo(tmp);
                if (cmp < 0) {
                    tmp = str2;
                    mem[0] = Long.parseLong(tmp);  mem[1] = i; mem[2] = j;
                }
            }
        }

        return mem;
    }
}
