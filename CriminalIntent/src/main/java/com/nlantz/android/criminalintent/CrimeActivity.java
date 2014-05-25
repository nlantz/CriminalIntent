package com.nlantz.android.criminalintent;

//Note "support" imports for backwards compatability

import android.support.v4.app.Fragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        //return new CrimeFragment();
        //Crime activity is now hosting an instance of CrimeListFragment
        //phew! that was easy!

        //instead of the previous this code allows the reuse of the fragment class
        //first get the crimeID
        UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        //then create a fragment with it
        return CrimeFragment.newInstance(crimeId);
        //this is good because the fragment doesnt have to know anything about the activity
        //this allows it to be called from anywhere as long as you have the data to build it
        //NOTE: the tag should always be stored in the fragment.
        //it doesnt make sense to store it somewhere else


    }
}















