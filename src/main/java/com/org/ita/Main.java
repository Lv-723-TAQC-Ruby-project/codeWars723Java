package com.org.ita;


import com.org.ita.utils.ConsoleReader;
import com.org.ita.utils.TaskRunner;
import com.org.ita.utils.Users;

import java.util.List;
import java.util.Locale;


public class Main {

    public static void main(String[] args) {
        List<String> tasks = List.of("Keep Hydrated!", "Volume", "Miles per gallon to kilometers per liter", "To square root or no to square", "Count of positives / sum of negatives", "Convert a String to a Number", "Willson primes", "Formatting decimal places", "Find numbers which are divisible by given number", "Looking for a benefactor", "Sum of the first nth term of Series", "Where is Vasya?", "Build a pile of Cubes", "Easy balance checking", "Floating-point Approximation (I)", "Rainfall: mean", "Rainfall: variance", "Ranking NBA", "Help the bookseller!", "Artificial Rain", "Gap in Primes", "Trailing zeros in factorial", "Perimeter of squares in a rectangle", "Which x for that sum?", "Find the smallest");
        ConsoleReader reader = new ConsoleReader();
        TaskRunner taskRunner = new TaskRunner();
        boolean run = true;

        while (run) {
            System.out.println("current user: " +taskRunner.getUser().getName() );
            System.out.println("0 exit;");
            System.out.println("1 set user ");
            System.out.println("2 run task ");
            int comandId = reader.readIntegerMinMax(0, 2);
            switch (comandId) {
                case 0:
                    run = false;
                    break;
                case 1:
                    Users.printALL();
                    int userId = reader.readIntegerMinMax(1, Users.values().length);
                    Users user = Users.getStudentById(userId);
                    taskRunner.setUser(user);
                    break;
                case 2:
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(i + "\t" + tasks.get(i));
                    }
                    int taskId = reader.readIntegerMinMax(0, tasks.size());
                    taskRunner.runTask(taskId);
                    break;
                default:
                    System.out.println("Enter a value between 0 2");

            }

        }
    }
}
