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
        String st = "Rome:Jan 81.2,Feb 63.2,Mar 70.3,Apr 55.7,May 53.0,Jun 36.4,Jul 17.5,Aug 27.5,Sep 60.9,Oct 117.7,Nov 111.0,Dec 97.9\n London:Jan 48.0,Feb 38.9,Mar 39.9,Apr 42.2,May 47.3,Jun 52.1,Jul 59.5,Aug 57.2,Sep 55.4,Oct 62.0,Nov 59.0,Dec 52.9 Paris:Jan 182.3,Feb 120.6,Mar 158.1,Apr 204.9,May 323.1,Jun 300.5,Jul 236.8,Aug 192.9,Sep 66.3,Oct 63.3,Nov 83.2,Dec 154.7\n NY:Jan 108.7,Feb 101.8,Mar 131.9,Apr 93.5,May 98.8,Jun 93.6,Jul 102.2,Aug 131.8,Sep 92.0,Oct 82.3,Nov 107.8,Dec 94.2\n Vancouver:Jan 145.7,Feb 121.4,Mar 102.3,Apr 69.2,May 55.8,Jun 47.1,Jul 31.3,Aug 37.0,Sep 59.6,Oct 116.3,Nov 154.6,Dec 171.5\n Sydney:Jan 103.4,Feb 111.0,Mar 131.3,Apr 129.7,May 123.0,Jun 129.2,Jul 102.8,Aug 80.3,Sep 69.3,Oct 82.6,Nov 81.4,Dec 78.2\n Bangkok:Jan 10.6,Feb 28.2,Mar 30.7,Apr 71.8,May 189.4,Jun 151.7,Jul 158.2,Aug 187.0,Sep 319.9,Oct 230.8,Nov 57.3,Dec 9.4 \n Tokyo:Jan 49.9,Feb 71.5,Mar 106.4,Apr 129.2,May 144.0,Jun 176.0,Jul 135.6,Aug 148.5,Sep 216.4,Oct 194.1,Nov 95.6,Dec 54.4 \n Beijing:Jan 3.9,Feb 4.7,Mar 8.2,Apr 18.4,May 33.0,Jun 78.1,Jul 224.3,Aug 170.0,Sep 58.4,Oct 18.0,Nov 9.3,Dec 2.7\n Lima:Jan 1.2,Feb 0.9,Mar 0.7,Apr 0.4,May 0.6,Jun 1.8,Jul 4.4,Aug 3.1,Sep 3.3,Oct 1.7,Nov 0.5,Dec 0.7";
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
