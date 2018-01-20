package com.derekpoon.workout;


import android.content.Context;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.widget.ListView;

/*
This does not need a layout and must extend List Fragment for list fragments
 */

public class WorkoutListFragment extends ListFragment {

    public WorkoutListFragment() {
        // Required empty public constructor
    }

    //add a listener to the fragment
    static interface WorkoutListListener {
        void itemClicked(long id);
    }

    private WorkoutListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //create a string array of workout names
        String[] names = new String[Workout.workouts.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Workout.workouts[i].getName();
        }

        //create an array adapter and get the context from it
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, names);

        //bind the array adapter to the listView
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //this is called when teh fragment gets attached to the activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (WorkoutListListener)context;
    }

    //tell the listener when an item in the ListView is clicked
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }
    }
}
