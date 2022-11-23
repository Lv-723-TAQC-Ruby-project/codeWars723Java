package com.org.ita.kata.implementation.LypskyiOleksandr;

import com.org.ita.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        long volume = 1L;
        long number_of_rows = 1L;
        while (volume < m) {
            number_of_rows += 1;
            volume += Math.pow(number_of_rows, 3);
        }
        return volume == m ? number_of_rows : -1;
    }

    @Override
    public String balance(String book) {
        return null;
    }

    @Override
    public double f(double x) {
        return 0;
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
