package com.org.ita.kata.implementation.KmytiukNatalyia;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Six;

public class SixImpl extends BaseKata implements Six {
    @Override
    public long findNb(long m) {
        long num = 0;
        long n = 0;
        for (n = 1; num < m; n++) {
            num += (long) Math.pow(n, 3);
        }
        return num == m ? n - 1 : -1;
    }

    @Override
    public String balance(String book) {
        return null;
    }

    @Override
    public double f(double x) {
        return  x / (1 + Math.sqrt(1 + x));
    }

    @Override
    public double mean(String town, String strng) {
        return 0;
    }

    @Override
    public double variance(String town, String strng) {
        return 0;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}
