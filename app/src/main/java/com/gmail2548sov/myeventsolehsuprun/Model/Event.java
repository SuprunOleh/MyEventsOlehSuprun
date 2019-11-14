package com.gmail2548sov.myeventsolehsuprun.Model;

import java.util.Date;
import java.util.UUID;

public class Event {

    private UUID mId;
    private String mTitle;
    private Date mData;
    private Date mLastRevisedDate;
    private Date mExpectedDateOfEvent;
    private Boolean mCompleted;


    public Event() {
        mId = UUID.randomUUID();
        mData = new Date();
    }


    public Boolean isCompleted() {
        return mCompleted;
    }
    public void setmCompleted(Boolean mCompleted) {
        this.mCompleted = mCompleted;
    }

    public Date getmLastRevisedDate() {
        return mLastRevisedDate;
    }
    public void setmLastRevisedDate(Date mLastRevisedDate) {this.mLastRevisedDate = mLastRevisedDate;
    }

    public Date getmExpectedDateOfEvent() {
        return mExpectedDateOfEvent;
    }
    public void setmExpectedDateOfEvent(Date mExpectedDateOfEvent) {this.mExpectedDateOfEvent = mExpectedDateOfEvent;
    }


    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {return mTitle;}
    public void setmTitle(String mTitle) {this.mTitle = mTitle;}

    public Date getmData() {return mData;}


    }







