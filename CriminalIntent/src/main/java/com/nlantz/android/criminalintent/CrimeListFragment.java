package com.nlantz.android.criminalintent;


//Note Support fragment import

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Nick Lantz on 4/6/14.
 */


public class CrimeListFragment extends ListFragment {

    private static final String TAG = "CrimeListFragment";
    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        getActivity().setTitle(R.string.crime_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();

        //set up adapter for list
        ArrayAdapter<Crime> adapter =
                    //pass in context, layout, and data
                new ArrayAdapter<Crime>(getActivity(),
                        android.R.layout.simple_list_item_1, //this is a predefined layout in android
                        mCrimes);
        //set it at the adapter for this listview
        setListAdapter(adapter);
    }

    @Override
    //when something is clicked the system calles this method for you
    //thats why none of these variables are anything we made already
    public void onListItemClick(ListView l, View v, int position, long id){

    }
}
