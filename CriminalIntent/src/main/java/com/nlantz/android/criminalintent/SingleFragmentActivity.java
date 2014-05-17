package com.nlantz.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by Nick Lantz on 5/17/14.
 * This is an abstract class used to create a single fragment activity
 */
public abstract class SingleFragmentActivity extends FragmentActivity {
    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        //for honeycomb only it would be...
        //FragmentManager fm = getFragmentManager();
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        //the fragment may already have been created and destroyed
        //if that was the case it will have been returned by fm ^^^^^^^^^^^
        //only create the fragment if this is the first time the program id being run
        if (fragment == null) {
            fragment = createFragment();
            //fluid interface. ie chain everything together
            //.get frag instance..add fragment to view..................commit
            fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
        //Activity is now hosting Fragment
    }
}
