package com.derekpoon.workout;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */

//this fragment class must extend Fragment
public class WorkoutDetailFragment extends Fragment {

    private long workoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }

    /*
    onCreateView is called when Android needs the fragment's layout
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //set the value of the workout id
        if (savedInstanceState != null) {
            workoutId = savedInstanceState.getLong("workoutId");
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView(); //gets the Fragment's root view
        if (view != null) {
            Workout workout = Workout.workouts[(int) workoutId];

            TextView title = (TextView) view.findViewById(R.id.textTitle);
            title.setText(workout.getName());

            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());

        }
    }

    //save the value of the workoutId in the savedInstanceState Bundle before
    //the fragment gets destroyed.
    //We're retrieving it in the onCreateView() method
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("workoutId", workoutId);
    }

    public void setWorkout(long id) {
        this.workoutId = id;
    }

}
