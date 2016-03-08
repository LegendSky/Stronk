package com.android.stronk.fragments.legs;

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


public class LegsWeight extends Fragment implements View.OnClickListener {

    private EditText etSquat;

    public LegsWeight() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_legs_weight, container, false);

        Button btnSaveSquat = (Button) view.findViewById(R.id.btnSaveSquat);

        btnSaveSquat.setOnClickListener(this);

        etSquat = (EditText) view.findViewById(R.id.etSquat);

        try {
            etSquat.setText(Double.toString(SharedPrefs.getWeightSquat(getContext())));
        } catch (Exception e) {
            // Invalid number saved in prefs.
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSaveSquat:
                try {
                    double squatWeight = Double.parseDouble(etSquat.getText().toString());
                    SharedPrefs.setWeightSquat(getContext(), squatWeight);
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
