package com.org.ita.kata.implementation.OmetiukhSofiia;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Six;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.List.of;
import static java.util.stream.Collectors.averagingDouble;

public class SixImpl extends BaseKata implements Six {
    public static List<Double> parseTemp(String town, String strng) {
        List<Double> temps = new ArrayList<>();
        for (String l : strng.split("\\n")) {
            String[] data = l.split(":");
            if (town.equals(data[0])) {
                for (String weather : data[1].split(",")) {
                    String[] temp = weather.split("\\s");
                    temps.add(Double.parseDouble(temp[1]));
                }
                break;
            }
        }
        if (temps.isEmpty()) temps.add(-1.0);
        return temps;
    }

    @Override
    public long findNb(long m) {
        long total = 1L;
        long n = 1L;
        while (total < m) {
            n += 1;
            total += n * n * n;
        }
        return total == m ? n : -1;
    }

    @Override
    public String balance(String book) {
        String s = book.replaceAll("([^\\n. \\da-zA-Z])", "");
        String[] arr = s.split("[\\n]+");
        double curr = Double.parseDouble(arr[0]);
        double total = 0;
        int count = 0;
        StringBuilder result = new StringBuilder();
        result.append("Balance: " + arr[0]);
        for (int i = 1; i < arr.length; i++) {
            count++;
            String[] l = arr[i].split("[ ]+");
            curr -= Double.parseDouble(l[2]);
            total += Double.parseDouble(l[2]);
            String r = String.format("\\r\\n%s %s %s Balance %.2f", l[0], l[1], l[2], curr);
            result.append(r);
        }
        result.append(String.format("\\r\\nTotal expense  %.2f\\r\\nAverage expense  %.2f", total, total / count));
        return result.toString();
    }

    @Override
    public double f(double x) {
        return x / (1 + Math.sqrt(1 + x));
    }

    @Override
    public double mean(String town, String strng) {
        return parseTemp(town, strng)
                .stream()
                .collect(averagingDouble(x -> x));
    }

    @Override
    public double variance(String town, String strng) {
        double mean = mean(town, strng);
        if (mean == -1.0)
            return -1.0;
        return parseTemp(town, strng)
                .stream()
                .collect(averagingDouble(x -> (x - mean) * (x - mean)));
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.isEmpty()) {
            return "";
        }
        int wins = 0, losses = 0, draws = 0, scored = 0, conceded = 0;
        for (var match : of(resultSheet.split(",")).stream().filter(s -> s.contains(toFind)).toArray(String[]::new)) {
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
        if (lstOfArt.length == 0) return "";
        final int space = lstOfArt[0].indexOf(" ");
        return Stream.of(lstOf1stLetter)
                .map(c -> c + " : " + Stream.of(lstOfArt)
                        .filter(a -> c.contentEquals(a.subSequence(0, 1)))
                .map(x->x.substring(space +1))
                .mapToInt(Integer::parseInt)
                .sum())
                .map(s->"(" + s + ")")
                .collect(Collectors.joining(" - "));
    }
}
