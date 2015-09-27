package com.android.stronk.fragments.pull1;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Chronometer;

import info.androidhive.stronk.R;
import com.android.stronk.activity.CheckBoxListener;

/**
 * @author Simin
 */
public class Pull1Workout extends Fragment {

    public Pull1Workout() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pull1_workout,
                container, false);

        // Chronometer.
        Chronometer chronometer = (Chronometer) view.findViewById(R.id.chronometer);

        // Ringtone.
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone ringtone = RingtoneManager.getRingtone(view.getContext(), notification);

        // Initialise checkboxes.
        CheckBox row1cb1 = (CheckBox) view.findViewById(R.id.row1checkBox1);

        CheckBox row2cb1 = (CheckBox) view.findViewById(R.id.row2checkBox1);
        CheckBox row2cb2 = (CheckBox) view.findViewById(R.id.row2checkBox2);
        CheckBox row2cb3 = (CheckBox) view.findViewById(R.id.row2checkBox3);

        CheckBox row3cb1 = (CheckBox) view.findViewById(R.id.row3checkBox1);
        CheckBox row3cb2 = (CheckBox) view.findViewById(R.id.row3checkBox2);
        CheckBox row3cb3 = (CheckBox) view.findViewById(R.id.row3checkBox3);
        CheckBox row3cb4 = (CheckBox) view.findViewById(R.id.row3checkBox4);

        CheckBox row4cb1 = (CheckBox) view.findViewById(R.id.row4checkBox1);
        CheckBox row4cb2 = (CheckBox) view.findViewById(R.id.row4checkBox2);
        CheckBox row4cb3 = (CheckBox) view.findViewById(R.id.row4checkBox3);
        CheckBox row4cb4 = (CheckBox) view.findViewById(R.id.row4checkBox4);

        // Add listener to checkbox.
        row1cb1.setOnClickListener(new CheckBoxListener(row1cb1, ringtone, chronometer));

        row2cb1.setOnClickListener(new CheckBoxListener(row2cb1, ringtone, chronometer));
        row2cb2.setOnClickListener(new CheckBoxListener(row2cb2, ringtone, chronometer));
        row2cb3.setOnClickListener(new CheckBoxListener(row2cb3, ringtone, chronometer));

        row3cb1.setOnClickListener(new CheckBoxListener(row3cb1, ringtone, chronometer));
        row3cb2.setOnClickListener(new CheckBoxListener(row3cb2, ringtone, chronometer));
        row3cb3.setOnClickListener(new CheckBoxListener(row3cb3, ringtone, chronometer));
        row3cb4.setOnClickListener(new CheckBoxListener(row3cb4, ringtone, chronometer));

        row4cb1.setOnClickListener(new CheckBoxListener(row4cb1, ringtone, chronometer));
        row4cb2.setOnClickListener(new CheckBoxListener(row4cb2, ringtone, chronometer));
        row4cb3.setOnClickListener(new CheckBoxListener(row4cb3, ringtone, chronometer));
        row4cb4.setOnClickListener(new CheckBoxListener(row4cb4, ringtone, chronometer));

        return view;
    }
}
