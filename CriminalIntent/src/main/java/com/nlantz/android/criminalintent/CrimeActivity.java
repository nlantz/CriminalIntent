package com.nlantz.android.criminalintent;

//Note "support" imports for backwards compatability

import android.support.v4.app.Fragment;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
        //Crime activity is now hosting an instance of CrimeListFragment
        //phew! that was easy!
    }
}















