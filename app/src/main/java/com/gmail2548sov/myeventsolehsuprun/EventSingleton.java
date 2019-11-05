package com.gmail2548sov.myeventsolehsuprun;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventSingleton {

    private static EventSingleton sEvenSingleton;
    private List<Event> mEvents;
    private final static String LOG_= "UUID";


    private EventSingleton(Context context) {
        mEvents = new ArrayList<>();
        for (int i = 0; i<50; i++) {
            Event event = new Event();
            event.setmTitle("Event " + (i+1));
            event.setmCompleted(true);
            Log.d (LOG_, event.getmTitle());
            mEvents.add(event);
        }
    }


    public static EventSingleton get(Context context) {
        if (sEvenSingleton == null) {
            sEvenSingleton = new EventSingleton(context);
        }
        return sEvenSingleton;
    }
    public List<Event> getEvents(){
        return mEvents;
    }
    public Event getEvent(UUID id) {
        for (Event event : mEvents) {
            if (event.getmId().equals(id)) {return event;}

        }
            return null;
    }








}
