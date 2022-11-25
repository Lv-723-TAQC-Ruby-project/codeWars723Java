package com.org.ita.kata.implementation.KulykMariia;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Six;

import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class SixImpl extends BaseKata implements Six {
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

        for (int i = 1; i < notes.length; i++) {
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

    public DoubleStream sortedData(String town, String strng) {
        return Stream.of(strng.split("\n"))
                .filter(s -> s.startsWith(town + ":"))
                .flatMapToDouble(s -> Stream.of(s.replaceAll("[^\\d.]", " ").trim().split("\\s+"))
                        .mapToDouble(Double::parseDouble));

    }

    @Override
    public double mean(String town, String strng) {
        return sortedData(town, strng).average().orElse(-1);
    }

    @Override
    public double variance(String town, String strng) {
        return sortedData(town, strng).map(m -> Math.pow(m - mean(town, strng), 2)).average().orElse(-1);
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        int wins = 0;
        int draws = 0;
        int lose = 0;
        int scored = 0;
        int conceded = 0;
        int points = 0;

        if (toFind.isEmpty()) {
            return "";
        }

        List<String> games = List.of(resultSheet.split(","));
        for (String game: games) {
            if (game.equals(".")) {
                System.out.println("Error(float number): " + game);
            }
        }

        List<String[]> teams = games.stream().map(game -> game.split("\\s\\d+(\\W|$)")).collect(Collectors.toList());
        List<Integer[]> scores = games.stream()
                .map(game -> Arrays.stream(game.split(" "))
                        .filter(x -> x.matches("\\d+"))
                        .map(Integer::valueOf).toArray(Integer[]::new))
                .collect(Collectors.toList());

        for (int i = 0; i < teams.size(); i++) {
            boolean draw = Objects.equals(scores.get(i)[0], scores.get(i)[1]);
            boolean teamFirst = teams.get(i)[0].equals(toFind);
            if (teamFirst) {
                scored += scores.get(i)[0];
                conceded += scores.get(i)[1];
            } else {
                scored += scores.get(i)[1];
                conceded += scores.get(i)[0];
            }
            if (Objects.equals(scores.get(i)[0], scores.get(i)[1])) {
                draws++;
                points++;
            } else if (scores.get(i)[0] < scores.get(i)[1]) {
                if (teamFirst) {
                    lose++;
                } else {
                    wins++;
                    points += 3;
                }
            } else {
                if (teamFirst) {
                    wins++;
                    points += 3;
                } else {
                    lose++;
                }
            }
        }
        return String.format(toFind + ":W=%s;D=%s;L=%s;Scored=%s;Conceded=%s;Points=%s",
                wins, draws, lose, scored, conceded, points);
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
