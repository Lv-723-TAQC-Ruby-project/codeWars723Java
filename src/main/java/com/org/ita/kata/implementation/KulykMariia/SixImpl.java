package com.org.ita.kata.implementation.KulykMariia;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Six;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import static java.util.stream.Stream.of;

public class SixImpl extends BaseKata implements Six {
    @Override
    public long findNb(long m) {
        long rectanglesCounter = 0;
        long totalVolume = 0;
        while (totalVolume < m) {
            totalVolume += ++rectanglesCounter * rectanglesCounter * rectanglesCounter;
        }
        return totalVolume == m ? rectanglesCounter : -1;
    }

    @Override
    public String balance(String book) {
        var lines = book.replaceAll("[^\\w\n. ]", "").split("\n");
        var report = new StringBuilder("Original Balance: " + lines[0] + (book = "\\r\\n"));
        double balance = Double.parseDouble(lines[0]), sum = 0;
        for (int i = 1; i < lines.length; i++) {
            sum += Double.parseDouble(lines[i].split("\\s+")[2]);
            report
                    .append(lines[i].trim().replaceAll("\\s+", " "))
                    .append(String.format(Locale.US, " Balance %.2f", balance - sum))
                    .append(book);
        }
        return report + String.format(Locale.US, "Total expense  %.2f%sAverage expense  %.2f", sum, book, sum / (lines.length - 1));
    }

    @Override
    public double f(double x) {
        return x / (1 + Math.sqrt(x + 1));
    }

    public DoubleStream sortedData(String town, String strng) {
        return Stream.of(strng.split("\n"))
                .filter(s -> s.startsWith(town + ":"))
                .flatMapToDouble(s -> Stream.of(s.replaceAll("[^\\d.]", " ").trim().split("\\s+"))
                        .mapToDouble(Double::parseDouble));
    }

    @Override
    public double mean(String town, String strng) {
        DoubleStream sortedData = Stream.of(strng.split("\n"))
                .filter(s -> s.startsWith(town + ":"))
                .flatMapToDouble(s -> Stream.of(s.replaceAll("[^\\d.]", " ").trim().split("\\s+"))
                        .mapToDouble(Double::parseDouble));
        return sortedData.average().orElse(-1);
    }

    @Override
    public double variance(String town, String strng) {
        return sortedData(town, strng).map(m -> Math.pow(m - mean(town, strng), 2)).average().orElse(-1);
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.isEmpty()) {
            return "";
        }

        int wins = 0, losses = 0, draws = 0, scored = 0, conceded = 0;
        for (var match : of(resultSheet.split(",")).filter(s -> s.contains(toFind)).toArray(String[]::new)) {
            if (match.contains(".")) {
                return "Error(float number):" + match;
            }

            var teams = match.substring(0, match.lastIndexOf(' ')).replaceAll(" \\d+ ", "@").split("@");
            if (teams[0].equals(toFind) || teams[1].equals(toFind)) {

                int pointsA = Integer.parseInt(match.substring(match.lastIndexOf(' ') + 1));
                int pointsB = Integer.parseInt(match.substring(teams[0].length() + 1, match.indexOf(teams[1]) - 1));
                if (match.startsWith(toFind)) {
                    int temp = pointsA;
                    pointsA = pointsB;
                    pointsB = temp;
                }

                scored += pointsA;
                conceded += pointsB;

                if (pointsA > pointsB) {
                    wins++;
                } else if (pointsA < pointsB) {
                    losses++;
                } else {
                    draws++;
                }
            }
        }
        return toFind + (scored + conceded > 0 ? ":W=" + wins + ";D=" + draws + ";L=" + losses + ";Scored=" + scored + ";Conceded=" + conceded + ";Points=" + (3 * wins + draws) : ":This team didn't play!");
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
