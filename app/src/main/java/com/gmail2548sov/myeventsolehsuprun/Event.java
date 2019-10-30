package com.gmail2548sov.myeventsolehsuprun;

import java.util.Date;
import java.util.UUID;

public class Event {

private UUID mId;
private String mTitle;
private Date mData;

public  Event(){
    mId = UUID.randomUUID();
    mData = new Date();
};

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getmData() {
        return mData;
    }

    public void setmData(Date mData) {
        this.mData = mData;
    }
}
