package com.gmail2548sov.myeventsolehsuprun.Сontroller;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import java.util.UUID;

public class EventActivity extends SingleFragmentActivity {

    public static final String EXTRA_EVENT_ID ="com.bignerdranch.android.criminalintent.crime_id";

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, EventActivity.class);
        intent.putExtra(EXTRA_EVENT_ID, crimeId);
        return intent;
    }






    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_EVENT_ID);
        return EventFragment.newInstance(crimeId);
    }



}
