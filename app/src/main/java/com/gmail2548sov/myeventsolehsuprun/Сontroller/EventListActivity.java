package com.gmail2548sov.myeventsolehsuprun.Сontroller;

import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.gmail2548sov.myeventsolehsuprun.Model.Event;
import com.gmail2548sov.myeventsolehsuprun.R;

public class EventListActivity extends SingleFragmentActivity implements EventListFragment.Callbacks{



    @Override
    protected Fragment createFragment() {
        return new EventListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onEventSelected(Event event) {

        if (findViewById(R.id.detail_fragment_container) == null) {
            Intent intent = EventPagerActivity.newIntent(this, event.getmId());
            startActivity(intent);
        } else {
            Fragment newDetail = EventFragment.newInstance(event.getmId());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, newDetail)
                    .commit();
        }

    }
}
