package com.android.stronk.fragments.pull1;

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


public class Pull1Other extends Fragment implements View.OnClickListener {

    private EditText etDeadlift;
    private EditText etPullUps;
    private EditText etHammerCurls;
    private EditText etDBCurls;

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

        Button btnSaveDeadlifts = (Button) view.findViewById(R.id.btnSaveDeadlifts);
        Button btnSavePullUps = (Button) view.findViewById(R.id.btnSavePullUps);
        Button btnSaveHammerCurls = (Button) view.findViewById(R.id.btnSaveHammerCurls);
        Button btnSaveDBCurls = (Button) view.findViewById(R.id.btnSaveDBCurls);

        btnSaveDeadlifts.setOnClickListener(this);
        btnSavePullUps.setOnClickListener(this);
        btnSaveHammerCurls.setOnClickListener(this);
        btnSaveDBCurls.setOnClickListener(this);

        etDeadlift = (EditText) view.findViewById(R.id.etDeadlift);
        etPullUps = (EditText) view.findViewById(R.id.etPullUps);
        etHammerCurls = (EditText) view.findViewById(R.id.etHammerCurls);
        etDBCurls = (EditText) view.findViewById(R.id.etDBCurls);

        try {
            etDeadlift.setText(Double.toString(SharedPrefs.getWeightDeadlift(getContext())));
            etPullUps.setText(Double.toString(SharedPrefs.getWeightPullUp(getContext())));
            etHammerCurls.setText(Double.toString(SharedPrefs.getWeightHammerCurl(getContext())));
            etDBCurls.setText(Double.toString(SharedPrefs.getWeightDBCurl(getContext())));
        } catch (Exception e) {
            // Invalid number saved in prefs.
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSaveDeadlifts:
                try {
                    double deadliftWeight = Double.parseDouble(etDeadlift.getText().toString());
                    SharedPrefs.setWeightDeadlift(getContext(), deadliftWeight);
                } catch (NumberFormatException e) {
                    // Input is not a number.
                }
                break;

            case R.id.btnSavePullUps:
                try {
                    double pullupWeight = Double.parseDouble(etPullUps.getText().toString());
                    SharedPrefs.setWeightPullUp(getContext(), pullupWeight);
                } catch (NumberFormatException e) {
                    // Input is not a number.
                }
                break;

            case R.id.btnSaveHammerCurls:
                try {
                    double hammercurlWeight = Double.parseDouble(etHammerCurls.getText().toString());
                    SharedPrefs.setWeightHammerCurl(getContext(), hammercurlWeight);
                } catch (NumberFormatException e) {
                    // Input is not a number.
                }
                break;

            case R.id.btnSaveDBCurls:
                try {
                    double dbcurlWeight = Double.parseDouble(etDBCurls.getText().toString());
                    SharedPrefs.setWeightDBCurl(getContext(), dbcurlWeight);
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
