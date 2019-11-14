package com.gmail2548sov.myeventsolehsuprun.Сontroller;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
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
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.gmail2548sov.myeventsolehsuprun.Model.Event;
import com.gmail2548sov.myeventsolehsuprun.Model.EventSingleton;
import com.gmail2548sov.myeventsolehsuprun.R;

import java.util.Date;
import java.util.UUID;


public class    EventFragment extends Fragment {

    private static final String ARG_EVENT_ID = "event_id";


    private EditText mTitleField;
    private Button mButton;
    private CheckBox mCheck;
    private TextView mEventTitle;


    private Event mEvent;
    private UUID eventId;

    private static final String LOG_xxx = "xxx";
    private static String CHANNEL_ID = "Channel";
    private int notific_ch = 0;


    public static EventFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_EVENT_ID, crimeId);
       EventFragment fragment = new EventFragment();
        fragment.setArguments(args);
        return fragment;
    }





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //eventId = (UUID)getActivity().getIntent().getSerializableExtra(EventActivity.EXTRA_EVENT_ID);

        UUID eventId = (UUID) getArguments().getSerializable(ARG_EVENT_ID);

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
                mEvent.setmTitle(s.toString());
                notific_ch++;









                Log.d ("Usama1","" + start);
                Log.d ("Usama1","" + before);
                Log.d ("Usama1","" + count);
                Log.d ("Usama1","" + s.toString());
                Log.d ("Usama1","" + notific_ch );


            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d ("Usama2", s.toString());


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


    @Override
    public void onStop() {
        super.onStop();
        int i;



        if (notific_ch>0) {

           EventSingleton.setNamber();
           i = EventSingleton.getNamber();

            Log.d ("Usama0","" + notific_ch);


            Intent resultIntent = new Intent(getContext(), EventPagerActivity.class);


            PendingIntent resultPendingIntent = PendingIntent.getActivity(getContext(), 0, resultIntent, 0);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(),CHANNEL_ID);

            builder.setSmallIcon(R.drawable.ic_stat_name)
                    .setContentTitle("Change - " + mEvent.getmTitle())
                    .setColor(Color.GREEN)
                    .setLights(Color.GREEN, 300, 300)
                    .setVibrate(new long[] { 100, 1000, 100, 1000 })
                    //.setDefaults(Notification.DEFAULT_SOUND)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.bender))
                    .setContentText("" + mEvent.getmId())
                    .setContentIntent(resultPendingIntent)
                    .setAutoCancel(true)
            .setNumber(i);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getContext());
            notificationManager.notify(i, builder.build());}


    }
}
