package com.org.ita.utils;

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
        // To do
    }
    public void runMpgToKPM() {
        // To do
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
        // To do
    }
    public void runDivisibleBy() {
        // To do
    }
    public void runNewAvg() {
        // To do
    }
    public void runSeriesSum() {
        // To do
    }
    public void runWhereIsHe() {
        // To do
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
        // To do
    }
    public void runStockSummary() {
        // To do
    }
    public void runArtificialRain() {
        // To do
    }
    public void runGap() {
        // To do
    }
    public void runZeros() {
        // To do
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
