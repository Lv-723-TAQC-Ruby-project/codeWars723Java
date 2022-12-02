package com.org.ita.kata.implementation.BrylAndrii;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Five;

import java.math.BigInteger;
import java.util.Arrays;

public class FiveImpl extends BaseKata implements Five {
    @Override
    public int artificialRain(final int[] v) {
        int[] flowRight = FiveImpl.computeRightFlow(v);
        int[] flowLeft = FiveImpl.computeLeftFlow(v);

        int maxWateredPlains = 0;

        for (int i = 0; i < flowLeft.length; i++) {
            maxWateredPlains = Math.max(flowLeft[i] + flowRight[i] + 1, maxWateredPlains);
        }
        return maxWateredPlains;
    }

    static boolean canFlowLeft(int[] numbers, int i) {
        if (i == 0)
            return false;
        return numbers[i - 1] <= numbers[i];
    }

    static boolean canFlowRight(int[] numbers, int i) {
        if (numbers.length - 1 == i)
            return false;
        return numbers[i + 1] <= numbers[i];
    }


    static int[] computeLeftFlow(int[] numbers) {
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (canFlowLeft(numbers, i)) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    static int[] computeRightFlow(int[] numbers) {
        int[] result = new int[numbers.length];

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (canFlowRight(numbers, i)) {
                result[i] = result[i + 1] + 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }


    //unction should return the first pair of two prime numbers spaced with a gap of g between the limits m, n if these numbers exist otherwise null
    @Override
    public long[] gap(int g, long m, long n) {
        long[] primes = generator(m, n);
        for (int i = 0; i < primes.length - 1; i++) {
            if (primes[i] >= m && primes[i] == primes[i + 1] - g) {
                return Arrays.copyOfRange(primes, i, i + 2);
            }
        }
        return null;
    }

    private static long[] generator(long m, long n) {
        long[] primes = new long[(int) (n - m)];
        int numPrimes = 0;
        boolean prime = true;
        for (int i = (int) m; i < (int) n; i++) {
            prime = true;
            for (int j = 2; j < Math.sqrt(i) + 1; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primes[numPrimes] = i;
                numPrimes++;
            }
        }
        return Arrays.copyOfRange(primes, 0, numPrimes);
    }

    @Override
    public int zeros(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;

        for (int i = 0; i <= n.intValue(); i++) {
            a = b;
            b = c;
            c = a.add(b);
            sum = sum.add(a);
        }

        return sum.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solveSum(double m) {
        return -(-2 * m + Math.sqrt(4 * m + 1) - 1) / (2 * m);
    }

    @Override
    public long[] smallest(long n) {
        long min = n;
        int index1 = 0;
        int index2 = 0;
        String number = String.valueOf(n);
        for (int i = 0; i < number.length(); i++) {
            for (int j = 0; j < number.length(); j++) {
                if (i != j && making(number, i, j) < min) {
                    min = making(number, i, j);
                    index1 = i;
                    index2 = j;
                }
            }
        }
        return new long[]{min, index1, index2};
    }

    public static long making(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        char c = sb.charAt(i);
        sb.deleteCharAt(i);
        sb.insert(j, c);

        return Long.parseLong(sb.toString());
    }
}
