package com.gmail2548sov.myeventsolehsuprun;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventListFragment extends Fragment {

    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;
    private final static String LOG_1= "ELF";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container,
                false);
        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.event_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager
                (getActivity()));
        updateUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }


    private void updateUI() {
        EventSingleton mEventSing = EventSingleton.get(getActivity());
        List<Event> crimes = mEventSing.getEvents();


       if (mAdapter == null) {



        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);}
       else{mAdapter.notifyDataSetChanged();    }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<EventHolder> {
        private List<Event> mEvents;

        public CrimeAdapter(List<Event> events) {
            mEvents = events;
        }

        @Override
        public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new EventHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(EventHolder holder, int position) {
            Event event = mEvents.get(position);
            holder.bind(event);
        }

        @Override
        public int getItemCount() {
            return mEvents.size();
        }


    }



    private class EventHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private Event mEvent;

        public EventHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item, parent, false));
            mTitleTextView = (TextView) itemView.findViewById(R.id.title_event);
            mDateTextView = (TextView) itemView.findViewById(R.id.title_date);
            itemView.setOnClickListener(this);
        }



        public void bind(Event event) {
            mEvent = event;
            mTitleTextView.setText(mEvent.getmTitle());
            mDateTextView.setText(mEvent.getmData().toString());
        }

        @Override
        public void onClick(View v) {
            Intent intent = EventPagerActivity.newIntent(getActivity(), mEvent.getmId());
            //Intent intent = EventActivity.newIntent(getActivity(), mEvent.getmId());
           // Intent intent = new Intent(getActivity(),EventActivity.class);
            Log.d (LOG_1, "IntentStart from EventListFragment");
            startActivity(intent);
        }
    }


}
