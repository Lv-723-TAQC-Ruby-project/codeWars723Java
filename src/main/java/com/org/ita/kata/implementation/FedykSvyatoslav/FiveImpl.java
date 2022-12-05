package com.org.ita.kata.implementation.FedykSvyatoslav;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Five;

import java.math.BigInteger;

public class FiveImpl extends BaseKata implements Five {
    @Override
    public int artificialRain(int[] v) {
        int left = 0, area = 0, record = 1;
        for(int i = 1; i < v.length; i++){
            if(v[i] < v[i - 1]) left = i;
            else if(v[i] > v[i-1]){

                    area = record;
                record = i - left;
            }
            record++;
        }

            return record;
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
        int res = 0;
        for (int i = 5; i <= n; i *= 5) {
            res += n / i;
        }
        return res;
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
