package com.gmail2548sov.myeventsolehsuprun;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class    EventFragment extends Fragment {

    private EditText mTitleField;
    private Button mButton;
    private CheckBox mCheck;
    private TextView mEventTitle;


    private Event mEvent;
    private UUID eventId;

    private static final String LOG_xxx = "xxx";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        eventId = (UUID)getActivity().getIntent().getSerializableExtra(EventActivity.EXTRA_EVENT_ID);
        mEvent = EventSingleton.get(getActivity()).getEvent(eventId);

        Log.d (LOG_xxx,mEvent.toString());

       // Log.d (LOG_UUID,mEvent.getmId().toString());
        //Log.d (LOG_UUID,mEvent.getmData().toString());






    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event, container, false);
        mEventTitle = (TextView)v.findViewById(R.id.event_title);
        mTitleField = (EditText)v.findViewById(R.id.event_title_hint);






        Log.d (LOG_xxx,mEvent.getmTitle());

        mTitleField.setText(mEvent.getmTitle());
        mTitleField.addTextChangedListener(new TextWatcher()     {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mEventTitle.setText(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        mButton = (Button) v.findViewById(R.id.button_event_date);
        Date data = new Date();
        mButton.setText(data.toString());
        mButton.setEnabled(false);




        mCheck = (CheckBox) v.findViewById(R.id.check_completed);

        mCheck.setChecked(mEvent.isCompleted());


        mCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //mEvent.setmCompleted(isChecked);

            }
        });
        return v;
    }
}
