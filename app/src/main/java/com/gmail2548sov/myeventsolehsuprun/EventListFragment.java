package com.gmail2548sov.myeventsolehsuprun;

import android.os.Bundle;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container,
                false);
        mCrimeRecyclerView = (RecyclerView) view
                .findViewById(R.id.event_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager
                (getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        EventSingleton mEventSing = EventSingleton.get(getActivity());
        List<Event> crimes = mEventSing.getEvents() ;
        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }

    private class EventHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private Event mEvent;
        public EventHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item, parent, false));
            mTitleTextView = (TextView) itemView.findViewById(R.id.title_event);
            mDateTextView = (TextView) itemView.findViewById(R.id.title_date);
        }

        public void bind(Event event) {
            mEvent = event;
            mTitleTextView.setText(mEvent.getmTitle());
            mDateTextView.setText(mEvent.getmData().toString());
        }
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



}
