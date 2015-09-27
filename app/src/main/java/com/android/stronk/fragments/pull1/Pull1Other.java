package com.android.stronk.fragments.pull1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.stronk.activity.SharedPrefs;

import info.androidhive.stronk.R;


public class Pull1Other extends Fragment implements View.OnClickListener {

    private Button btnSave;
    private EditText editText;
    private TextView textView;

    public Pull1Other() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pull1_other, container, false);

        btnSave = (Button) view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        editText = (EditText) view.findViewById(R.id.etWeight);
        textView = (TextView) view.findViewById(R.id.tvWeight);

        textView.setText("deadlift: " + SharedPrefs.getWeightDeadlift());
        return view;
    }

    @Override
    public void onClick(View v) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPrefs.setWeightDeadlift(preferences, Integer.parseInt(editText.getText().toString()));
        textView.setText("Deadlift: " + SharedPrefs.getWeightDeadlift());
        System.out.println(SharedPrefs.getWeightDeadlift());
    }
}
