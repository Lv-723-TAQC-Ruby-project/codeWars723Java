package com.org.ita.utils;

import java.util.Arrays;

public class TaskRunner {
    private Users user = Users.BRYL_ANDRII;
    private final ConsoleReader reader = new ConsoleReader();

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public void runTask(int taskId) {
        switch (taskId) {
            case 0:
                runLiters();
                break;
            case 1:
                runGetVolumeOfCuboid();
                break;
            case 2:
                runMpgToKPM();
                break;
            case 3:
                runSquareOrSquareRoot();
                break;
            case 4:
                runCountPositivesSumNegatives();
                break;
            case 5:
                runStringToNumber();
                break;
            case 6:
                runAmIWilson();
                break;
            case 7:
                runTwoDecimalPlaces();
                break;
            case 8:
                runDivisibleBy();
                break;
            case 9:
                runNewAvg();
                break;
            case 10:
                runSeriesSum();
                break;
            case 11:
                runWhereIsHe();
                break;
            case 12:
                runFindNb();
                break;
            case 13:
                runBalance();
                break;
            case 14:
                runF();
                break;
            case 15:
                runMean();
                break;
            case 16:
                runVariance();
                break;
            case 17:
                runNbaCup();
                break;
            case 18:
                runStockSummary();
                break;
            case 19:
                runArtificialRain();
                break;
            case 20:
                runGap();
                break;
            case 21:
                runZeros();
                break;
            case 22:
                runPerimeter();
                break;
            case 23:
                runSolveSum();
                break;
            case 24:
                runSmallest();
        }
    }
    public void runLiters() {
        System.out.println("Run task liters");
        System.out.print("Please input time (hours): ");
        double hours = reader.readDouble();
        int result = user.getEight().liters(hours);
        System.out.println("Result - " + result + " hours.");
    }
    public void runGetVolumeOfCuboid() {
        System.out.println("Run task Volume of Cuboid");
        System.out.println("Please, input the length: ");
        double length = reader.readDouble();
        System.out.println("Please, input the width: ");
        double width = reader.readDouble();
        System.out.println("Please, input the height: ");
        double height = reader.readDouble();
        double result = user.getEight().getVolumeOfCuboid(length, width, height);
        System.out.println("The volume of cuboid is: " + result);
    }
    public void runMpgToKPM() {
        System.out.println("Run task Miles per gallon to kilometers per liter\n");
        System.out.println("Please, input float to check: ");
        float number = reader.readFloat();
        float result = user.getEight().mpgToKPM(number);
        System.out.println("The result of converting -> " + result);
    }
    public void runSquareOrSquareRoot() {
        // To do
    }
    public void runCountPositivesSumNegatives() {
        //To do
    }
    public void runStringToNumber() {
        // To do
    }
    public void runAmIWilson() {
        System.out.println("Run task am I Wilson");
        System.out.println("Please, input number to check: ");
        int number = reader.readInteger();
        boolean result = user.getEight().amIWilson(number);
        System.out.println("Is this number wilson number? -> " + result);
    }
    public void runTwoDecimalPlaces() {
        System.out.println("Run task two decimal places");
        System.out.println("Please, input number to round: ");
        double number = reader.readDouble();
        double result = user.getEight().twoDecimalPlaces(number);
        System.out.println("You number is rounded to two decimal places -> " + result);
    }
    public void runDivisibleBy() {
        System.out.println("Run task 'Find numbers which are divisible by given number'");
        System.out.println("Please, input numbers");
        int[] numbers = reader.readIntArr();
        System.out.println("Please, input divisor");
        int divisor = reader.readInteger();
        int[] result = user.getEight().divisibleBy(numbers, divisor);
        System.out.println("Result: " + Arrays.toString(result));
    }
    public void runNewAvg() {
        // To do
    }
    public void runSeriesSum() {
        System.out.println("Run task Sum of the first nth term of Series");
        System.out.println("Please input the integer number: ");
        int n = reader.readInteger();
        String result = user.getSeven().seriesSum(n);
        System.out.println("The sum of following series is: " + result);
    }
    public void runWhereIsHe() {
        System.out.println("Run task Where is Vasya?\n");
        System.out.println("Please, input integers: 1. total amount of people in the line;\n");
        int p = reader.readInteger();
        System.out.println("2. number of people standing in front of him\n");
        int bef = reader.readInteger();
        System.out.println("3. number of people standing behind him");
        int aft = reader.readInteger();
        int result = user.getSeven().whereIsHe(p,bef,aft);
        System.out.println("Vasya's position  -> " + result);
    }
    public void runFindNb() {
        // To do
    }
    public void runBalance() {
        // To do
    }
    public void runF() {
        // To do
    }
    public void runMean() {
        System.out.println("Run task Rainfall: mean (return average for city)");
        System.out.println("Please, enter city to check: ");
        String city = reader.readString();
        System.out.println("Please, enter data to define average from: ");
        String data = reader.readString();
        double result = user.getSix().mean(city, data);
        System.out.println("Average for " + city + " is " + result);
    }
    public void runVariance() {
        System.out.println("Run task Rainfall: variance (should return the variance of rainfall for the city)");
        System.out.println("Please, enter city to check: ");
        String city = reader.readString();
        System.out.println("Please enter data to deal with: ");
        String data = reader.readString();
        double result = user.getSix().variance(city, data);
        System.out.println("Result is: " + result);
    }
    public void runNbaCup() {
        System.out.println("Run task Ranking NBA:");
        System.out.println("Please, enter team's name to see the scores: ");
        String toFind = reader.readString();
        System.out.println("Please, enter scores: ");
        String resultSheet = reader.readString();
        String result = user.getSix().nbaCup(resultSheet,toFind);
        System.out.println(" " + result);
    }
    public void runStockSummary() {
        System.out.println("Run task 'Help the bookseller'");
        String[] stocklist = {"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        System.out.println("Stocklist:");
        System.out.println(Arrays.toString(stocklist));
        System.out.println("Please input list of categories");
        String[] categories = reader.readStringArr();
        String result = user.getSix().stockSummary(stocklist, categories);
        System.out.println("Result: " + result);

    }
    public void runArtificialRain() {
        // To do
    }
    public void runGap() {
        System.out.println("Run task Gap in Primes");
        System.out.println("Please, input the integer number of the gap we are looking for: ");
        int g = reader.readInteger();
        System.out.println("Please, input the start of the search: ");
        long m = reader.readLong();
        System.out.println("Please, input the end of the search: ");
        long n = reader.readLong();
        long [] result = user.getFive().gap(g, m, n);
        System.out.println("The first pair of two prime numbers is: " + result);
    }
    public void runZeros() {
        System.out.println("Run task am Number of trailing zeros of N!");
        System.out.println("Please, input number to check of trailing zeros: ");
        int number = reader.readInteger();
        int result = user.getFive().zeros(number);
        System.out.println("The number of trailing zeros in a factorial of a given number is -> " + result);
    }
    public void runPerimeter() {
        // To do
    }
    public void runSolveSum() {
        // To do
    }
    public void runSmallest() {
        // To do
    }
}
