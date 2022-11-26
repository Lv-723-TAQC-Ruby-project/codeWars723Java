package com.org.ita.kata.implementation.KovalyovVladyslav;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Six;

public class SixImpl extends BaseKata implements Six {
    @Override
    public long findNb(long m) {
        long n = 1;
        while ( m >  0 ) {
            m -= (n*n*n);
            n++;
        }
        if ( m == 0 ) {
            return n-1;
        }
        return -1;
    }

    @Override
    public String balance(String book) {
        var lines = book.replaceAll("[^\\w\n. ]", "").split("\n");
        var newLine = "\\r\\n";
        var report = new StringBuilder("Original Balance: " + lines[0] + newLine);
        double balance = Double.parseDouble(lines[0]);
        double sum = 0;
        for (int i = 1; i < lines.length; i++) {
            sum += Double.parseDouble(lines[i].split("\\s+")[2]);
            report.append(lines[i].trim().replaceAll("\\s+", " ")).append(String.format(" Balance %.2f", balance - sum)).append(newLine);
        }
        return report + String.format("Total expense  %.2f%sAverage expense  %.2f", sum, newLine, sum / (lines.length - 1));
    }

    @Override
    public double f(double x) {
        double result = x / (1 + Math.sqrt(x + 1));
        return result;
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
