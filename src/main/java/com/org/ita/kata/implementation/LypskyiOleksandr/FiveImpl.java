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
        long prime = 0;
        long current = m;
        while (current <= n) {
            if (isPrime(current)) {
                if (prime == 0) {
                    prime = current;
                } else {
                    if (current - prime == g) {
                        return new long[]{prime, current};
                    } else {
                        prime = current;
                    }
                }
            }
            ++current;
        }
        return null;
    }

    public static boolean isPrime(long n) {
        if (n == 2) {
            return true;
        }
        if (n <= 1 || n % 2 == 0) {
            return false;
        }
        int max = (int) Math.floor(Math.sqrt(n));
        for (int i = 3; i <= max; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
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
        return (2 * m + 1 - Math.sqrt(4 * m + 1)) / (2 * m);
    }

    @Override
    public long[] smallest(long n) {
        long lowestNumber = n;
        long[] arrayToReturn = new long[]{};
        String number = String.valueOf(n);
        int length = number.length();
        for (int i = 0; i < length; i++) {
            String withOutI = number.substring(0, i) + number.substring(i + 1);
            for (int j = 0; j < length; j++) {
                long numberToCompare = Long.parseLong(withOutI.substring(0, j) + number.charAt(i) + withOutI.substring(j));
                if (numberToCompare < lowestNumber) {
                    lowestNumber = numberToCompare;
                    arrayToReturn = new long[]{numberToCompare, i, j};
                }
            }
        }
        return arrayToReturn;
    }
}
