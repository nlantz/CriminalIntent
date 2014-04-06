package com.nlantz.android.criminalintent;

//Note "support" imports for backwards compatability
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;

public class CrimeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        //for honeycomb only it would be...
        //FragmentManager fm = getFragmentManager();
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        //the fragment may already have been created and destroyed
        //if that was the case it will have been returned by fm ^^^^^^^^^^^
        //only create the fragment if this is the first time the program id being run
        if(fragment==null){
            fragment = new CrimeFragment();
            fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
        //CrimeActivity is now hosting CrimeFragment
    }

}
