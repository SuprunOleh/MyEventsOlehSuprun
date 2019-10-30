package com.gmail2548sov.myeventsolehsuprun;

import androidx.fragment.app.Fragment;

public class EventListActivity extends SingleFragmentActivity {



    @Override
    protected Fragment createFragment() {
        return new EventListFragment();
    }
}
