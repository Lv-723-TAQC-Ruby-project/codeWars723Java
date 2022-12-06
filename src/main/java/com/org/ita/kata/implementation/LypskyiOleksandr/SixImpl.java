package com.org.ita.kata.implementation.LypskyiOleksandr;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Six;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class SixImpl extends BaseKata implements Six {
    public static List<Double> data_to_list(String town, String strng) {
        String[] allTowns = strng.split("\n");


        List<Double> townData = new ArrayList<>();
        for (String townString : allTowns) {
            String[] townSplit = townString.split(":");
            String townName = townSplit[0];
            if (townName.equals(town)) {
                String[] townValues = townSplit[1].split(",");
                List<Double> listOfValues = new ArrayList<>();
                for (String townValue : townValues) {
                    listOfValues.add(Double.parseDouble(townValue.split(" ")[1]));
                }
                double mean = listOfValues.stream().collect(Collectors.summingDouble(Double::doubleValue)) / townValues.length;
                List<Double> listOfVariance = new ArrayList<>();
                for (Object value : listOfValues) {
                    listOfVariance.add((mean - (double) value) * (mean - (double) value));
                }
                double variance = listOfVariance.stream().collect(Collectors.summingDouble(Double::doubleValue)) / listOfVariance.size();
                townData.addAll(Arrays.asList(mean, variance));
            }

        }
        if (townData.size() == 0) {

        }
        return townData;
    }

    @Override
    public long findNb(long m) {
        long volume = 1L;
        long numberOfRows = 1L;
        while (volume < m) {
            numberOfRows += 1;
            volume += Math.pow(numberOfRows, 3);
        }
        return volume == m ? numberOfRows : -1;
    }

    @Override
    public String balance(String book) {
        String[] arrayOfStrings = book.split("\n");
        Pattern decimalNumPattern = Pattern.compile("\\d+(\\.\\d+)?");
        Pattern wordPattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = decimalNumPattern.matcher(arrayOfStrings[0]);
        matcher.find();
        double balance = Double.parseDouble(matcher.group(0));
        String stringToReturn = "Original Balance: " + String.format(Locale.US,"%.2f", balance);
        double totalExpense = 0;
        double totalItems = 0;
        for (int i = 1; i < arrayOfStrings.length; i++) {

            String preparedString = arrayOfStrings[i].replaceAll("\\s+", "");
            Matcher matcherName = wordPattern.matcher(preparedString);
            matcherName.find();
            String nameOfItem = matcherName.group(0);
            String[] tempArray = arrayOfStrings[i].split(nameOfItem);
            Matcher matcherPrice = decimalNumPattern.matcher(tempArray[1]);
            matcherPrice.find();
            double priceOfItem = Double.parseDouble(matcherPrice.group(0));
            totalExpense += priceOfItem;
            totalItems += 1;
            balance -= priceOfItem;
            stringToReturn += "\\r\\n" + tempArray[0] + nameOfItem + " " + String.format(Locale.US,"%.2f", priceOfItem) + " Balance " + String.format(Locale.US,"%.2f", balance);
        }
        stringToReturn += "\\r\\nTotal expense  " + String.format(Locale.US,"%.2f", totalExpense) + "\\r\\nAverage expense  " + String.format(Locale.US,"%.2f", (totalExpense / totalItems));
        return stringToReturn;
    }

    @Override
    public double f(double x) {
        return x / (1 + Math.sqrt(x + 1));
    }

    @Override
    public double mean(String town, String strng) {
        List<Double> data = data_to_list(town, strng);
        return data.get(0);

    }

    @Override
    public double variance(String town, String strng) {
        List<Double> data = data_to_list(town, strng);
        return data.get(1);
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
         if (resultSheet == null || resultSheet.isEmpty() || toFind == null || toFind.isEmpty()) return "";
        HashMap<String, int[]> teamResults = new HashMap<>();
        String[] rawData = resultSheet.split(",");
        Pattern firstDigitRegex = Pattern.compile("\\d{2,3}");
        Pattern lastDigitRegex = Pattern.compile("\\d{2,3}$");
        for (String res : rawData) {
            if (res.contains(".")) return "Error(float number):" + res;
            res = res.replaceAll(",$", "");
            Matcher firstScoreMatcher = firstDigitRegex.matcher(res);
            Matcher secondScoreMatcher = lastDigitRegex.matcher(res);
            firstScoreMatcher.find();
            int firstTeamScore = Integer.parseInt(firstScoreMatcher.group(0));
            secondScoreMatcher.find();
            int secondTeamScore = Integer.parseInt(secondScoreMatcher.group(0));
            String[] teamNames = res.split(String.valueOf(firstTeamScore));
            String firstTeamName = teamNames[0].strip();
            String[] secondTeamNameArray = teamNames[1].split(" ");
            secondTeamNameArray = Arrays.copyOfRange(secondTeamNameArray, 1, secondTeamNameArray.length - 1);
            String secondTeamName = String.join(" ", secondTeamNameArray).strip();
            teamResults.putIfAbsent(firstTeamName, new int[]{0, 0, 0, 0, 0, 0});
            teamResults.putIfAbsent(secondTeamName, new int[]{0, 0, 0, 0, 0, 0});
            int[] firstTeamStats = teamResults.get(firstTeamName);
            int[] secondTeamStats = teamResults.get(secondTeamName);
            if (firstTeamScore > secondTeamScore) {
                firstTeamStats[0] += 1;
                firstTeamStats[3] += firstTeamScore;
                firstTeamStats[4] += secondTeamScore;
                firstTeamStats[5] += 3;
                secondTeamStats[2] += 1;
                secondTeamStats[3] += secondTeamScore;
                secondTeamStats[4] += firstTeamScore;
            } else {
                secondTeamStats[0] += 1;
                secondTeamStats[3] += secondTeamScore;
                secondTeamStats[4] += firstTeamScore;
                secondTeamStats[5] += 3;
                firstTeamStats[2] += 1;
                firstTeamStats[3] += firstTeamScore;
                firstTeamStats[4] += secondTeamScore;
            }
        }
        if (teamResults.containsKey(toFind)) {
            int[] teamStats = teamResults.get(toFind);
            return toFind + ":W=" + teamStats[0] + ";D=" + teamStats[1] + ";L=" + teamStats[2] + ";Scored=" + teamStats[3] + ";Conceded=" + teamStats[4] + ";Points=" + teamStats[5];
        } else {
            return toFind + ":This team didn't play!";
        }
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
         StringBuilder toReturn = new StringBuilder();
        if (lstOfArt.length != 0 && lstOf1stLetter.length != 0) {
            for (int i = 0; i < lstOf1stLetter.length; i++) {
                String category = lstOf1stLetter[i];
                int count = 0;
                for (String Artstr : lstOfArt) {
                    if (Artstr.substring(0, 1).equals(category)) {
                        String[] book = Artstr.split(" ");
                        count += Integer.parseInt(book[1]);
                    }
                }
                String stock = "(" + category + " : " + count + ")";
                if (i != (lstOf1stLetter.length - 1)) {
                    toReturn.append(stock).append(" - ");
                } else {
                    toReturn.append(stock);
                }
            }
        }
        return toReturn.toString();
    }
}
