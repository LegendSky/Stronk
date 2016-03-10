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
        TextView tvFrontSquatWeight = (TextView) view.findViewById(R.id.tvFrontSquatWeight);
        TextView tvGluteHamRaisesWeight = (TextView) view.findViewById(R.id.tvGluteHamRaisesWeight);
        TextView tvCalfRaisesWeight = (TextView) view.findViewById(R.id.tvCalfRaisesWeight);

        tvSquatWeight.setText(Double.toString(SharedPrefs.getWeightSquat(getContext())));
        tvRomanianDeadliftWeight.setText(Double.toString(SharedPrefs.getWeightRomDeadlift(getContext())));
        tvFrontSquatWeight.setText(Double.toString(SharedPrefs.getWeightFrontSquat(getContext())));
        tvGluteHamRaisesWeight.setText(Double.toString(SharedPrefs.getWeightGluteHamRaises(getContext())));
        tvCalfRaisesWeight.setText(Double.toString(SharedPrefs.getWeightCalfRaises(getContext())));

        // Chronometer.
        Chronometer chronometer = (Chronometer) view.findViewById(R.id.chronometer);

        // Ringtone.
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone ringtone = RingtoneManager.getRingtone(view.getContext(), notification);

        // Initialize checkboxes.
        CheckBox row1cb1 = (CheckBox) view.findViewById(R.id.row1checkBox1);
        CheckBox row1cb2 = (CheckBox) view.findViewById(R.id.row1checkBox2);
        CheckBox row1cb3 = (CheckBox) view.findViewById(R.id.row1checkBox3);

        CheckBox row2cb1 = (CheckBox) view.findViewById(R.id.row2checkBox1);
        CheckBox row2cb2 = (CheckBox) view.findViewById(R.id.row2checkBox2);
        CheckBox row2cb3 = (CheckBox) view.findViewById(R.id.row2checkBox3);

        CheckBox row3cb1 = (CheckBox) view.findViewById(R.id.row3checkBox1);
        CheckBox row3cb2 = (CheckBox) view.findViewById(R.id.row3checkBox2);
        CheckBox row3cb3 = (CheckBox) view.findViewById(R.id.row3checkBox3);

        CheckBox row4cb1 = (CheckBox) view.findViewById(R.id.row4checkBox1);
        CheckBox row4cb2 = (CheckBox) view.findViewById(R.id.row4checkBox2);
        CheckBox row4cb3 = (CheckBox) view.findViewById(R.id.row4checkBox3);

        CheckBox row5cb1 = (CheckBox) view.findViewById(R.id.row5checkBox1);
        CheckBox row5cb2 = (CheckBox) view.findViewById(R.id.row5checkBox2);
        CheckBox row5cb3 = (CheckBox) view.findViewById(R.id.row5checkBox3);
        CheckBox row5cb4 = (CheckBox) view.findViewById(R.id.row5checkBox4);
        CheckBox row5cb5 = (CheckBox) view.findViewById(R.id.row5checkBox5);

        // Add listener to checkbox.
        row1cb1.setOnClickListener(new CheckBoxListener(row1cb1, ringtone, chronometer));
        row1cb2.setOnClickListener(new CheckBoxListener(row1cb2, ringtone, chronometer));
        row1cb3.setOnClickListener(new CheckBoxListener(row1cb3, ringtone, chronometer));

        row2cb1.setOnClickListener(new CheckBoxListener(row2cb1, ringtone, chronometer));
        row2cb2.setOnClickListener(new CheckBoxListener(row2cb2, ringtone, chronometer));
        row2cb3.setOnClickListener(new CheckBoxListener(row2cb3, ringtone, chronometer));

        row3cb1.setOnClickListener(new CheckBoxListener(row3cb1, ringtone, chronometer));
        row3cb2.setOnClickListener(new CheckBoxListener(row3cb2, ringtone, chronometer));
        row3cb3.setOnClickListener(new CheckBoxListener(row3cb3, ringtone, chronometer));

        row4cb1.setOnClickListener(new CheckBoxListener(row4cb1, ringtone, chronometer));
        row4cb2.setOnClickListener(new CheckBoxListener(row4cb2, ringtone, chronometer));
        row4cb3.setOnClickListener(new CheckBoxListener(row4cb3, ringtone, chronometer));

        row5cb1.setOnClickListener(new CheckBoxListener(row5cb1, ringtone, chronometer));
        row5cb2.setOnClickListener(new CheckBoxListener(row5cb2, ringtone, chronometer));
        row5cb3.setOnClickListener(new CheckBoxListener(row5cb3, ringtone, chronometer));
        row5cb4.setOnClickListener(new CheckBoxListener(row5cb4, ringtone, chronometer));
        row5cb5.setOnClickListener(new CheckBoxListener(row5cb5, ringtone, chronometer));

        return view;
    }
}
