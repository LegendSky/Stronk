package com.android.stronk.fragments.pull2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.android.stronk.activity.SharedPrefs;

import info.androidhive.stronk.R;


public class Pull2Weight extends Fragment implements View.OnClickListener {

    private EditText etBenchPress;
    private EditText etOHPress;
    private EditText etInclineDBPress;
    private EditText etOHLat;

    public Pull2Weight() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_pull2_weight, container, false);

        Button btnSaveBenchPress = (Button) view.findViewById(R.id.btnSaveBenchPress);
        Button btnSaveOHPress = (Button) view.findViewById(R.id.btnSaveOHPress);
        Button btnSaveInclineDBPress = (Button) view.findViewById(R.id.btnSaveInclineDBPress);
        Button btnSaveOHLat = (Button) view.findViewById(R.id.btnSaveOHLat);

        btnSaveBenchPress.setOnClickListener(this);
        btnSaveOHPress.setOnClickListener(this);
        btnSaveInclineDBPress.setOnClickListener(this);
        btnSaveOHLat.setOnClickListener(this);

        etBenchPress = (EditText) view.findViewById(R.id.etDeadlift);
        etOHPress = (EditText) view.findViewById(R.id.etPullUps);
        etInclineDBPress = (EditText) view.findViewById(R.id.etHammerCurls);
        etOHLat = (EditText) view.findViewById(R.id.etDBCurls);

        try {
            etBenchPress.setText(Double.toString(SharedPrefs.getWeightDeadlift(getContext())));
            etOHPress.setText(Double.toString(SharedPrefs.getWeightPullUp(getContext())));
            etInclineDBPress.setText(Double.toString(SharedPrefs.getWeightHammerCurl(getContext())));
            etOHLat.setText(Double.toString(SharedPrefs.getWeightDBCurl(getContext())));
        } catch (Exception e) {
            // Invalid number saved in prefs.
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSaveBenchPress:
                try {
                    double benchPressWeight = Double.parseDouble(etBenchPress.getText().toString());
                    SharedPrefs.setWeightBenchPress(getContext(), benchPressWeight);
                } catch (NumberFormatException e) {
                    // Input is not a number.
                }
                break;

            case R.id.btnSaveOHPress:
                try {
                    double ohPressWeight = Double.parseDouble(etOHPress.getText().toString());
                    SharedPrefs.setWeightOHPress(getContext(), ohPressWeight);
                } catch (NumberFormatException e) {
                    // Input is not a number.
                }
                break;

            case R.id.btnSaveHammerCurls:
                try {
                    double inclineDBWeight = Double.parseDouble(etInclineDBPress.getText().toString());
                    SharedPrefs.setWeightInclineDBPress(getContext(), inclineDBWeight);
                } catch (NumberFormatException e) {
                    // Input is not a number.
                }
                break;

            case R.id.btnSaveOHLat:
                try {
                    double OHLatWeight = Double.parseDouble(etOHLat.getText().toString());
                    SharedPrefs.setWeightOHLat(getContext(), OHLatWeight);
                } catch (NumberFormatException e) {
                    // Input is not a number.
                }
                break;
        }

        // Hide keyboard after hitting save.
        InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(v.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
