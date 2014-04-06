package com.nlantz.android.criminalintent;


//Note Support fragment import
import android.os.Bundle;
import android.support.v4.app.ListFragment;

import java.util.ArrayList;

/**
 * Created by Nick Lantz on 4/6/14.
 */


public class CrimeListFragment extends ListFragment{

    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        getActivity().setTitle(R.string.crime_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();
    }
}
