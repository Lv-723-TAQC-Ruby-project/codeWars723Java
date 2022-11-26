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
        // To do
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


}
