package com.org.ita.kata.implementation.KulykMariia;

import com.org.ita.kata.Six;

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
        //book = book.replace("[^a-zA-Z ]", "");
        //String[] lines = book.split("\n");


        return book;
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
