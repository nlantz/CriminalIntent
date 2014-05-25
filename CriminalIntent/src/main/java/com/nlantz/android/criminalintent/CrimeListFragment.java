package com.nlantz.android.criminalintent;


//Note Support fragment import

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

        //instead of the standard adapter we are going to use our custom adapter
        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }

    @Override
    //when something is clicked the system calles this method for you
    //thats why none of these variables are anything we made already
    public void onListItemClick(ListView l, View v, int position, long id) {
        //.................getListAdapter.................
        //is a method for convenience so we can do everyting in one line
        //...................................getItem
        //returns the gets the object stored at "position"
        //we then have a Crime item stored in an array adapter type
        // simply cast this and then you have your Crime object c
        Crime c = ((CrimeAdapter) getListAdapter()).getItem(position);

        //when you click on a crime, start the CrimeActivity
        //note getActivity gets this activity
        Intent i = new Intent(getActivity(), CrimeActivity.class);
        //pass in which array element was clicked
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getId());
        //start that bitch
        startActivity(i);

    }

    //set up an inner class that will act as a custom adapter
    private class CrimeAdapter extends ArrayAdapter<Crime> {

        public CrimeAdapter(ArrayList<Crime> crimes) {
            //call super to link the inner class to the listFragment
            //the 0 would normally be a layout but we are not using this
            super(getActivity(), 0, crimes);
        }

        //this is the magic here
        //override the getView so we send the system what we want when is asks
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //if there is no View we need to create one
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
            }

            //Configure the individual element in this list
            Crime c = getItem(position);

            //set the text for the title based on the position on the list
            TextView titleTextView = (TextView) convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getTitle());

            //do this for the other elements
            TextView dateTextView = (TextView) convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateTextView.setText(c.getDate().toString()); //note the toString.. we didn't override this

            CheckBox solvedCheckBox = (CheckBox) convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(c.isSolved());

            return convertView;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        ((CrimeAdapter) getListAdapter()).notifyDataSetChanged();
    }
}
