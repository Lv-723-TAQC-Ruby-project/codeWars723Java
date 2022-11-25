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
        }
    }
    public void runLiters() {
        System.out.println("Run task liters");
        System.out.print("Please input time (hours): ");
        double hours = reader.readDouble();
        int result = user.getEight().liters(hours);
        System.out.println("Result - " + result + " hours.");
    }


}
