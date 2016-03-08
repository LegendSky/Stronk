package com.android.stronk.fragments.legs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.stronk.activity.SharedPrefs;

import info.androidhive.stronk.R;


public class LegsWarmUp extends Fragment {

    public LegsWarmUp() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_legs_warmup, container, false);

        TextView squatWarmUpWeight = (TextView) view.findViewById(R.id.tvSquatWeight);

        squatWarmUpWeight.setText(getSquatWarmUp());

        // Inflate the layout for this fragment
        return view;
    }

    private String getSquatWarmUp() {
        String warmup;
        double weightSquat = SharedPrefs.getWeightSquat(getContext());
        if (weightSquat < 30)
            warmup = "No warm up";
        else if (weightSquat < 40)
            warmup = "(5 x 20) & (5 x 20)";
        else if (weightSquat < 50)
            warmup = "(5 x 20) & (5 x 20) & (5 x 30)";
        else if (weightSquat < 60)
            warmup = "(5 x 20) & (5 x 20) & (5 x 40)";
        else if (weightSquat < 70)
            warmup = "(5 x 20) & (5 x 20) & (5 x 40) & (5 x 50)";
        else if (weightSquat < 75)
            warmup = "(5 x 20) & (5 x 20) & (5 x 40) & (5 x 55)";
        else
            warmup = "Expand this app.";

        return warmup;
    }

    private String getPullupWarmUp() {
        return "No warm up";
    }

}
