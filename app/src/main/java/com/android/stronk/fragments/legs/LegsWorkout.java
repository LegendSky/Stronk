package com.android.stronk.fragments.legs;

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
import android.widget.TextView;

import com.android.stronk.activity.CheckBoxListener;
import com.android.stronk.activity.SharedPrefs;

import info.androidhive.stronk.R;

public class LegsWorkout extends Fragment {

    public LegsWorkout() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_legs_workout,
                container, false);

        TextView tvSquatWeight = (TextView) view.findViewById(R.id.tvSquatWeight);
        TextView tvRomanianDeadliftWeight = (TextView) view.findViewById(R.id.tvRomanianDeadliftWeight);

        tvSquatWeight.setText(Double.toString(SharedPrefs.getWeightSquat(getContext())));
        tvRomanianDeadliftWeight.setText(Double.toString(SharedPrefs.getWeightRomDeadlift(getContext())));

        // Chronometer.
        Chronometer chronometer = (Chronometer) view.findViewById(R.id.chronometer);

        // Ringtone.
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone ringtone = RingtoneManager.getRingtone(view.getContext(), notification);

        // Initialise checkboxes.
        CheckBox row1cb1 = (CheckBox) view.findViewById(R.id.row1checkBox1);
        CheckBox row1cb2 = (CheckBox) view.findViewById(R.id.row1checkBox2);
        CheckBox row1cb3 = (CheckBox) view.findViewById(R.id.row1checkBox3);

        // Initialise checkboxes.
        CheckBox row2cb1 = (CheckBox) view.findViewById(R.id.row2checkBox1);
        CheckBox row2cb2 = (CheckBox) view.findViewById(R.id.row2checkBox2);
        CheckBox row2cb3 = (CheckBox) view.findViewById(R.id.row2checkBox3);

        // Add listener to checkbox.
        row1cb1.setOnClickListener(new CheckBoxListener(row1cb1, ringtone, chronometer));
        row1cb2.setOnClickListener(new CheckBoxListener(row1cb2, ringtone, chronometer));
        row1cb3.setOnClickListener(new CheckBoxListener(row1cb3, ringtone, chronometer));

        row2cb1.setOnClickListener(new CheckBoxListener(row2cb1, ringtone, chronometer));
        row2cb2.setOnClickListener(new CheckBoxListener(row2cb2, ringtone, chronometer));
        row2cb3.setOnClickListener(new CheckBoxListener(row2cb3, ringtone, chronometer));

        return view;
    }
}
