package com.colors;

import java.util.Scanner;

public class TestClient {
    public static void main(String[] args) {
        System.out.println("Welcome to ColorsZym App");
        System.out.println("Please register with your details");
        
        // Create objects
        UserImpl userobj = new UserImpl();
        WorkoutImpl workoutobj = new WorkoutImpl();

        // User registration
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your first name");
        String s1 = s.next();
        System.out.println("Please enter your last name");
        String s2 = s.next();
        System.out.println("Please enter your username");
        String c = s.next();
        System.out.println("Please enter your password");
        String d = s.next();

        User user = new User("Jyothi", "Mayee", "JyothiMayee", "jyo123");
        userobj.register(user, 0);

        System.out.println("Thank you ... your details are with us");
        System.out.println("Please login with your details");
        System.out.println("Please enter your username");
        System.out.println("Please enter your password");

        boolean result = userobj.login("JyothiMayee", "jyo123");
        System.out.println("User login: " + result);

        if (result) {
            System.out.println("jyothi...welcome to ColorsZym");
            System.out.println("Please follow the menu below for your fitness");

            // Work out
            WorkOut workout = new WorkOut("cardio", "treadmill", 0, 10, "fitness");
            WorkOut workout1 = new WorkOut("muscle", "dumbell", 20, 10, "strength");

            workoutobj.addWorkout(workout, 0);
            workoutobj.addWorkout(workout1, 1);

            WorkOut[] workouts = workoutobj.displayWorkouts();
            for (WorkOut work : workouts) {
                if (work != null) {
                    System.out.println(work);
                }
            }
        } else {
            System.out.println("Login failed. Please try again.");
        }
    }
}
