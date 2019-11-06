package com.gmail2548sov.myeventsolehsuprun;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.UUID;

public class EventPagerActivity extends AppCompatActivity {

    private static final String EXTRA_CRIME_ID = "com.gmail2548sov.myeventsolehsuprun.event_id";

    private ViewPager mViewPager;
    private List<Event> mEvents;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_pager);

        UUID eventId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CRIME_ID);


        mViewPager = (ViewPager) findViewById(R.id.event_view_page);
        mEvents = EventSingleton.get(this).getEvents();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

            @Override
            public Fragment getItem(int position) {
                Event event = mEvents.get(position);
                return EventFragment.newInstance(event.getmId());
            }

            @Override
            public int getCount() {
                return mEvents.size();
            }
        });
        for (int i = 0; i < mEvents.size(); i++) {
            if (mEvents.get(i).getmId().equals(eventId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }




    }

    public static Intent newIntent(Context packageContext, UUID eventId) {
        Intent intent = new Intent(packageContext, EventPagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, eventId);
        return intent;
    }
}
