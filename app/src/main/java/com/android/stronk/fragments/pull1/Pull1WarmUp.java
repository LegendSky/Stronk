package com.android.stronk.fragments.pull1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.android.stronk.activity.SharedPrefs;

import info.androidhive.stronk.R;


public class Pull1WarmUp extends Fragment {

    public Pull1WarmUp() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pull1_warmup, container, false);

        TextView deadliftWarmUpWeight = (TextView) view.findViewById(R.id.tvDeadliftWeight);
        TextView pullupWarmUpWeight = (TextView) view.findViewById(R.id.tvPullUpWeight);
        TextView hammercurlWarmUpWeight = (TextView) view.findViewById(R.id.tvHammerCurlsWeight);
        TextView dbcurlWarmUpWeight = (TextView) view.findViewById(R.id.tvDBCurlsWeight);

        deadliftWarmUpWeight.setText(getDeadliftWarmUp());
        pullupWarmUpWeight.setText(getPullupWarmUp());
        hammercurlWarmUpWeight.setText("No warm up");
        dbcurlWarmUpWeight.setText("No warm up");

        // Inflate the layout for this fragment
        return view;
    }

    private String getDeadliftWarmUp() {
        String warmup;
        double weightDeadlift = SharedPrefs.getWeightDeadlift(getContext());
        if (weightDeadlift < 70)
            warmup = "No warm up.";
        else if (weightDeadlift < 80)
            warmup = "(1 x 60)";
        else if (weightDeadlift < 90)
            warmup = "(1 x 60) & (1 x 70)";
        else
            warmup = "Expand this app.";

        return warmup;
    }

    private String getPullupWarmUp() {
        return "0";
    }

}
