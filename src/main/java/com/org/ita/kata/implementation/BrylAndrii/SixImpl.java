package com.org.ita.kata.implementation.BrylAndrii;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Six;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SixImpl extends BaseKata implements Six {
    @Override
    public long findNb(long m) {
        long output = 1;
        long check = 0;
        while (check <= m) {
            check += (long) Math.pow(output, 3);
            if (check == m) {
                return output;
            }
            output++;
        }
        return -1;
    }

    @Override
    public String balance(String book) {
        String t = book.replaceAll("([^\\n. \\da-zA-Z])", "");
        String[] arr = t.split("\\n+");
        double current = Double.parseDouble(arr[0]);
        double total = 0;
        int count = 0;
        StringBuilder result = new StringBuilder();
        result.append("Original Balance: ").append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            count++;
            String[] line = arr[i].split(" +");
            current -= Double.parseDouble(line[2]);
            total += Double.parseDouble(line[2]);
            String u = String.format("\\r\\n%s %s %s Balance %.2f", line[0], line[1], line[2], current);
            result.append(u);
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
        String[] arr = strng.split("\\n+");
        for (String s : arr) {
            String[] line = s.split(":");
            if (line[0].equals(town)) {
                String[] data = line[1].split(",");
                double sum = 0;
                for (String datum : data) {
                    sum += Double.parseDouble(datum.split(" ")[1]);
                }
                return sum / data.length;
            }
        }
        return -1;
    }

    @Override
    public double variance(String town, String strng) {
        String[] arr = strng.split("\\n+");
        for (String s : arr) {
            String[] line = s.split(":");
            if (line[0].equals(town)) {
                String[] data = line[1].split(",");
                double sum = 0;
                for (String datum : data) {
                    sum += Double.parseDouble(datum.split(" ")[1]);
                }
                double mean = sum / data.length;
                double variance = 0;
                for (String datum : data) {
                    variance += Math.pow(Double.parseDouble(datum.split(" ")[1]) - mean, 2);
                }
                return variance / data.length;
            }
        }
        return -1;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.equals(""))
            return "";
        int countTeamname = toFind.split(" ").length;
        String[] split = resultSheet.split(",");
        int points = 0;
        int won = 0;
        int draw = 0;
        int lost = 0;
        int scored = 0;
        int conceded = 0;
        for (String temp : split) {
            int ownPoints = 0;
            int oppPoints = 0;
            boolean teamFound = false;
            String[] parts = temp.split(" ");
            if (countTeamname == 2) {
                teamFound = (parts[0].equals(toFind.split(" ")[0]) && parts[1].equals(toFind.split(" ")[1]))
                        || (parts[parts.length - 3].equals(toFind.split(" ")[0])
                        && parts[parts.length - 2].equals(toFind.split(" ")[1]));
            } else {
                teamFound = (parts[0].equals(toFind.split(" ")[0]) && parts[1].equals(toFind.split(" ")[1])
                        && parts[2].equals(toFind.split(" ")[2]))
                        || (parts[parts.length - 4].equals(toFind.split(" ")[0])
                        && parts[parts.length - 3].equals(toFind.split(" ")[1])
                        && parts[parts.length - 2].equals(toFind.split(" ")[2]));
            }

            if (teamFound) {
                try {
                    if (toFind.split(" ")[0].equals(parts[0])) {
                        if (toFind.split(" ").length == 2) {
                            ownPoints = Integer.parseInt(parts[2]);
                        } else {
                            ownPoints = Integer.parseInt(parts[3]);
                        }
                        oppPoints = Integer.parseInt(parts[parts.length - 1]);
                    } else {
                        if (toFind.split(" ").length == 2) {
                            oppPoints = Integer.parseInt(parts[parts.length - 4]);
                        } else {
                            oppPoints = Integer.parseInt(parts[parts.length - 5]);
                        }
                        ownPoints = Integer.parseInt(parts[parts.length - 1]);
                    }
                } catch (NumberFormatException e) {
                    return "Error(float number):" + temp;
                }
                scored += ownPoints;
                conceded += oppPoints;
                if (ownPoints > oppPoints) {
                    points += 3;
                    won++;
                } else if (ownPoints == oppPoints) {
                    points += 1;
                    draw++;
                } else {
                    lost++;
                }
            }

        }

        if (won == 0 && draw == 0 && lost == 0) {
            return toFind + ":This team didn't play!";
        } else {
            return toFind + ":W=" + won + ";D=" + draw + ";L=" + lost + ";Scored=" + scored + ";Conceded=" + conceded
                    + ";Points=" + points;
        }
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (String s : lstOf1stLetter) {
            int sum = 0;
            for (String value : lstOfArt) {
                if (value.startsWith(s)) {
                    sum += Integer.parseInt(value.split(" ")[1]);
                }
            }
            result.append("(").append(s).append(" : ").append(sum).append(") - ");
        }
        return result.substring(0, result.length() - 3);
    }
}
