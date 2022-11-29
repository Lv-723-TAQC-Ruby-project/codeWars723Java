package com.org.ita.kata.implementation.FedykSvyatoslav;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Five;

import java.math.BigInteger;

public class FiveImpl extends BaseKata implements Five {
    @Override
    public int artificialRain(int[] v) {
        return 0;
    }

    @Override
    public long[] gap(int g, long m, long n) {
        for (long i = m; i < n; i++) {
            for (long j = i + 1; j <= i + g; j++) {
                if (isPrime(i) && isPrime(j)) {
                    if(j-i == g){
                        return new long[] { i, j };
                    }else break;
                }
            }
        }
        return null;
    }

    public static boolean isPrime(long number) {
        return BigInteger.valueOf(number).isProbablePrime(20);
    }

    @Override
    public int zeros(int n) {
        return 0;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger a = new BigInteger("1"), b = new BigInteger("1"), c = new BigInteger("0");
        BigInteger res = new BigInteger("2");
        for(int i = 3; i <= n.intValue()+1; i++){
            c = a.add(b);
            res = res.add(c);
            a = b;
            b = c;
        }
        return res.multiply(new BigInteger("4"));
    }

    @Override
    public double solveSum(double m) {
        return (2 * m + 1 - java.lang.Math.sqrt(4 * m + 1)) / (2 * m);
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
