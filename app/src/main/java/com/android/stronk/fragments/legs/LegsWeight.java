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

    private EditText etSquat, etRomDeadlift, etFrontSquat, etGluteHamRaises, etCalfRaises;

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
        Button btnSaveRomDeadlift = (Button) view.findViewById(R.id.btnSaveRomDeadlift);
        Button btnSaveFrontSquat = (Button) view.findViewById(R.id.btnSaveFrontSquat);
        Button btnSaveGluteHamRaises = (Button) view.findViewById(R.id.btnSaveGluteHamRaises);
        Button btnSaveCalfRaises = (Button) view.findViewById(R.id.btnSaveCalfRaises);

        btnSaveSquat.setOnClickListener(this);
        btnSaveRomDeadlift.setOnClickListener(this);
        btnSaveFrontSquat.setOnClickListener(this);
        btnSaveGluteHamRaises.setOnClickListener(this);
        btnSaveCalfRaises.setOnClickListener(this);

        etSquat = (EditText) view.findViewById(R.id.etSquat);
        etRomDeadlift = (EditText) view.findViewById(R.id.etRomDeadlift);
        etFrontSquat = (EditText) view.findViewById(R.id.etFrontSquat);
        etGluteHamRaises = (EditText) view.findViewById(R.id.etGluteHamRaises);
        etCalfRaises = (EditText) view.findViewById(R.id.etCalfRaises);

        try {
            etSquat.setText(Double.toString(SharedPrefs.getWeightSquat(getContext())));
            etRomDeadlift.setText(Double.toString(SharedPrefs.getWeightRomDeadlift(getContext())));
            etFrontSquat.setText(Double.toString(SharedPrefs.getWeightFrontSquat(getContext())));
            etGluteHamRaises.setText(Double.toString(SharedPrefs.getWeightGluteHamRaises(getContext())));
            etCalfRaises.setText(Double.toString(SharedPrefs.getWeightCalfRaises(getContext())));
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
            case R.id.btnSaveRomDeadlift:
                try {
                    double romDeadliftWeight = Double.parseDouble(etRomDeadlift.getText().toString());
                    SharedPrefs.setWeightRomDeadlift(getContext(), romDeadliftWeight);
                } catch (NumberFormatException e) {
                    // Input is not a number.
                }
                break;
            case R.id.btnSaveFrontSquat:
                try {
                    double weight = Double.parseDouble(etFrontSquat.getText().toString());
                    SharedPrefs.setWeightFrontSquat(getContext(), weight);
                } catch (NumberFormatException e) {
                    // Input is not a number.
                }
                break;
            case R.id.btnSaveGluteHamRaises:
                try {
                    double weight = Double.parseDouble(etGluteHamRaises.getText().toString());
                    SharedPrefs.setWeightGluteHamRaises(getContext(), weight);
                } catch (NumberFormatException e) {
                    // Input is not a number.
                }
                break;
            case R.id.btnSaveCalfRaises:
                try {
                    double weight = Double.parseDouble(etCalfRaises.getText().toString());
                    SharedPrefs.setWeightCalfRaises(getContext(), weight);
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
