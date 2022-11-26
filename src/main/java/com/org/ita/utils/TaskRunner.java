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
                runStringToNumber();
                break;
            case 5:
                runAmIWilson();
                break;
            case 6:
                runTwoDecimalPlaces();
                break;
            case 7:
                runDivisibleBy();
                break;
            case 8:
                runNewAvg();
                break;
            case 9:
                runSeriesSum();
                break;
            case 10:
                runWhereIsHe();
                break;
            case 11:
                runFindNb();
                break;
            case 12:
                runBalance();
                break;
            case 13:
                runF();
                break;
            case 14:
                runMean();
                break;
            case 15:
                runVariance();
                break;
            case 16:
                runNbaCup();
                break;
            case 17:
                runStockSummary();
                break;
            case 18:
                runArtificialRain();
                break;
            case 19:
                runGap();
                break;
            case 20:
                runZeros();
                break;
            case 21:
                runPerimeter();
                break;
            case 22:
                runSolveSum();
                break;
            case 23:
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
        // To do
    }
    public void runVariance() {
        // To do
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
