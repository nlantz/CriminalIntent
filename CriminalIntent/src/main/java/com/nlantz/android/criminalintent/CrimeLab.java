package com.nlantz.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Nick Lantz on 4/6/14.
 * <p/>
 * This is a Singleton Class as to allow fro centeralized data storage
 */
public class CrimeLab {


    private ArrayList<Crime> mCrimes;
    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    //Note the constructor is private.
    //class conot be instantiated directly through constructor
    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();

        //for now just generate a bunch of boring crimes for testing
        for (int i = 0; i < 100; i++) {
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved(i % 2 == 0);
            mCrimes.add(c);
        }
    }

    public static CrimeLab get(Context c) {
        //If there is no crime lab in the system you need to create one
        if (sCrimeLab == null) {
            //note get"application"context is only because this is a global singleton
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        //if one is there return it
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime c : mCrimes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }
}
