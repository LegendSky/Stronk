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

    private EditText etBBRows;
    private EditText etPullUps;
    private EditText etHammerCurls;
    private EditText etDBCurls;

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

        Button btnSaveBBRows = (Button) view.findViewById(R.id.btnSaveBBRows);
        Button btnSavePullUps = (Button) view.findViewById(R.id.btnSavePullUps);
        Button btnSaveHammerCurls = (Button) view.findViewById(R.id.btnSaveHammerCurls);
        Button btnSaveDBCurls = (Button) view.findViewById(R.id.btnSaveDBCurls);

        btnSaveBBRows.setOnClickListener(this);
        btnSavePullUps.setOnClickListener(this);
        btnSaveHammerCurls.setOnClickListener(this);
        btnSaveDBCurls.setOnClickListener(this);

        etBBRows = (EditText) view.findViewById(R.id.etBBRows);
        etPullUps = (EditText) view.findViewById(R.id.etPullUps);
        etHammerCurls = (EditText) view.findViewById(R.id.etHammerCurls);
        etDBCurls = (EditText) view.findViewById(R.id.etDBCurls);

        try {
            etBBRows.setText(Double.toString(SharedPrefs.getWeightBBRow(getContext())));
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
            case R.id.btnSaveBBRows:
                try {
                    double bbrowWeight = Double.parseDouble(etBBRows.getText().toString());
                    SharedPrefs.setWeightBBRow(getContext(), bbrowWeight);
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
