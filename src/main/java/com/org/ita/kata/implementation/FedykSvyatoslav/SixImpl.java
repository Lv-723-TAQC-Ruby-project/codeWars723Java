package com.org.ita.kata.implementation.FedykSvyatoslav;

import static java.util.stream.Collectors.averagingDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import com.org.ita.kata.BaseKata;
import com.org.ita.kata.Six;

public class SixImpl extends BaseKata implements Six {
    @Override
    public long findNb(long m) {
        long n = 0;
        long cubeSize = 0;
        for (; cubeSize < m; n++)
            cubeSize += n * n * n;
        return (cubeSize == m) ? n - 1 : -1;
    }

    @Override
    public String balance(String book) {
        StringBuilder result = new StringBuilder();
        String[] splittedBook = book.replaceAll("[^a-zA-Z0-9 \\n.]","").replaceAll(" {2,}", " ").split("\n");
        double balance = Double.parseDouble(splittedBook[0]);
        double expense = 0;
        result.append("Original Balance: ").append(String.format(Locale.US,"%1$.2f", balance)).append("\\r\\n");
        for(int i = 1; i < splittedBook.length; i++) {
            String[] splittedItem = splittedBook[i].split(" ");
            double itemExpense = Double.parseDouble(splittedItem[splittedItem.length - 1]);
            balance -= itemExpense;
            expense += itemExpense;
            result.append(splittedBook[i].trim()).append(" Balance ").append(String.format(Locale.US,"%1$.2f", balance)).append("\\r\\n");
        }
        result.append("Total expense  ").append(String.format(Locale.US,"%1$.2f", expense)).append("\\r\\n");
        result.append("Average expense  ").append(String.format(Locale.US,"%1$.2f", expense / (splittedBook.length - 1)));

        return result.toString();
    }

    @Override
    public double f(double x) {
        return x / (1 + Math.sqrt(1 + x));
    }

    @Override
    public double mean(String town, String strng) {
        return temp(town, strng).stream()
                .collect(averagingDouble(n -> n));
    }

    @Override
    public double variance(String town, String strng) {
        double mean = mean(town, strng);
        if (mean == -1.0) return -1.0;

        return temp(town, strng).stream()
                .collect(averagingDouble(n -> (n - mean) * (n - mean)));
    }

    private static List<Double> temp(String town, String strng) {
        List<Double> temps = new ArrayList<>();
        for (String line : strng.split("\\n")) {
            String[] data = line.split(":");
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
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.equals("")) return "";
        String[] split = resultSheet.split(",");
        int countstrLength = toFind.split(" ").length;
        int noofMatches = 0, pointsob = 0, pointslos = 0, totalpointslos =0,totalpointsob=0,wincount =0, loscount =0,draws = 0, score=0;
        for(String temp : split){
            int index = temp.indexOf(toFind);
            if(Character.isLetter(temp.charAt(index + toFind.length())))
                index = -1;
            if(index != -1){
                boolean firstteam = false;
                noofMatches++;
                try {
                    int cindex = index - 2;
                    if(Character.isDigit(temp.charAt(cindex)))
                        firstteam = false;
                }
                catch(Exception e){
                    firstteam = true;
                }
                String[] innerSplit = temp.split(" ");
                if(firstteam){
                    try {pointsob = Integer.parseInt(innerSplit[countstrLength]);
                        pointslos = Integer.parseInt(innerSplit[innerSplit.length - 1]);
                        if(pointsob > pointslos)
                            wincount++;
                        else if (pointsob == pointslos)
                            draws++;
                        else
                            loscount++;
                        totalpointsob += pointsob;
                        totalpointslos += pointslos;
                        score = 3 * wincount + 1 * draws + 0 * loscount;}
                    catch (NumberFormatException e) {
                        return "Error(float number):" + temp;
                    }
                }
                else {
                    try{pointsob = Integer.parseInt(innerSplit[innerSplit.length -1]);
                        pointslos = Integer.parseInt(innerSplit[innerSplit.length - 1 - countstrLength - 1]);
                        if(pointsob > pointslos)
                            wincount++;
                        else if (pointsob == pointslos)
                            draws++;
                        else
                            loscount++;
                        totalpointsob += pointsob;
                        totalpointslos += pointslos;
                        score = 3 * wincount + 1 * draws + 0 * loscount;}
                    catch (NumberFormatException e) {
                        return "Error(float number):" + temp;
                    }
                }
            }
        }
        if ( wincount ==0 && draws==0 && loscount ==0)
            return (toFind+":This team didn't play!");
        return (toFind+":"+"W="+wincount+";D="+draws+";L="+loscount+";Scored="+totalpointsob+";Conceded="+totalpointslos+";Points="+score);
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0) return "";
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
