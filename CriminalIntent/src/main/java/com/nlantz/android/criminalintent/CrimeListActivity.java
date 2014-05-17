package com.nlantz.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Nick Lantz on 5/17/14.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
