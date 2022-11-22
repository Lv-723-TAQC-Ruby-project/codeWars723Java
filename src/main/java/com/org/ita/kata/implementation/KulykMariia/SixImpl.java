package main.java.com.org.ita.kata.implementation.KulykMariia;

import main.java.com.org.ita.kata.Six;

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
        return null;
    }
}
