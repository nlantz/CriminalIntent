package com.nlantz.android.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Nick Lantz on 4/5/14.
 */
public class Crime {


    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;


    public Crime() {
        //Generate Unique Identifier
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }


    //im not too sold on doing it this way.
    //but this returns the title instead of the memory address when called by the system
    //maybe use adapter to set title manually instead
    //but it works i guess
    @Override
    public String toString(){
        return mTitle;
    }

}
