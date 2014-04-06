package com.nlantz.android.criminalintent;

import java.util.UUID;

/**
 * Created by Nick Lantz on 4/5/14.
 */
public class Crime {


    private UUID mId;
    private String mTitle;

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Crime(){
        //Generate Unique Identifier
        mId = UUID.randomUUID();
    }

}
