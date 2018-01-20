package com.derekpoon.workout;

/**
 * Created by derekpoon on 03/12/2017.
 */

public class Workout {

    private String name;
    private String description;

    //simple array of workouts
    public static final Workout[] workouts = {
            new Workout("The Limb Loosener",
                    "5 Handstand push-ups\n10 1-legged squats\n15 pull-ups"),
            new Workout("Core Agony",
                    "100 pull-ups\n10 1-legged squats\n15 pull-ups"),
            new Workout("The Wimp Special",
                    "5 pull-ups\n10 1-legged squats\n15 pull-ups"),
            new Workout("Strength and Length",
                    "500 meter run\n10 1-legged squats\n15 pull-ups")
    };

    //each workout has a name and description
    private Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
