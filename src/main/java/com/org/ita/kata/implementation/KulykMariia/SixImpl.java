package com.org.ita.kata.implementation.KulykMariia;

import com.org.ita.kata.Six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        long rectanglesCounter = 0;
        long totalVolume = 0;
        while (totalVolume <= m) {
            rectanglesCounter++;
            totalVolume += Math.pow(rectanglesCounter, 3);
        }
        if (m == totalVolume) {
            return rectanglesCounter;
        } else return -1;
    }

    @Override
    public String balance(String book) {
        String bookSorted = book.replaceAll("[^a-zA-Z ]", "");

        double[] values = Pattern.compile("\\d+\\.\\d+").matcher(bookSorted).results()
                .map(MatchResult::group)
                .mapToDouble(Double::parseDouble)
                .toArray();

        String[] notes = bookSorted.split("\n");
        List<String> res = new ArrayList<>();
        res.add(String.format("Original Balance: %.2f", values[0]));

        for(int i = 1; i < notes.length; i++) {
            values[0] -= values[i];
            res.add(String.format("%s Balance %.2f", notes[i].trim(), values[0]));
        }

        DoubleSummaryStatistics dsm = Arrays.stream(values, 1, values.length)
                .summaryStatistics();
        res.add(String.format("Total expense  %.2f", dsm.getSum()));
        res.add(String.format("Average expense  %.2f", dsm.getAverage()));

        return String.join("\\r\\n", res);
    }

    @Override
    public double f(double x) {
        return x / (1 + Math.sqrt(x + 1));
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
        if (lstOfArt.length == 0) {
            return "";
        }

        final int space = lstOfArt[0].indexOf(" ");

        return Stream.of(lstOf1stLetter)
                .map(c -> c + " : " + Stream.of(lstOfArt)
                        .filter(a -> c.contentEquals(a.subSequence(0, 1)))
                        .map(a -> a.substring(space + 1))
                        .mapToInt(Integer::parseInt)
                        .sum())
                .map(s -> "(" + s + ")")
                .collect(Collectors.joining(" - "));

    }
}
