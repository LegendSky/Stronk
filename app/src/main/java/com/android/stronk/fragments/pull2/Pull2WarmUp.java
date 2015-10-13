package com.android.stronk.fragments.pull2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.stronk.activity.SharedPrefs;

import info.androidhive.stronk.R;


public class Pull2WarmUp extends Fragment {

    public Pull2WarmUp() {
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
        View view = inflater.inflate(R.layout.fragment_pull2_warmup, container, false);

        TextView bbrowWarmUpWeight = (TextView) view.findViewById(R.id.tvBBRowWeight);
        TextView pullupWarmUpWeight = (TextView) view.findViewById(R.id.tvPullUpWeight);
        TextView hammercurlWarmUpWeight = (TextView) view.findViewById(R.id.tvHammerCurlsWeight);
        TextView dbcurlWarmUpWeight = (TextView) view.findViewById(R.id.tvDBCurlsWeight);

        bbrowWarmUpWeight.setText(getBBRowWarmUp());
        pullupWarmUpWeight.setText(getPullupWarmUp());
        hammercurlWarmUpWeight.setText("No warm up");
        dbcurlWarmUpWeight.setText("No warm up");

        // Inflate the layout for this fragment
        return view;
    }

    private String getBBRowWarmUp() {
        String warmup;
        double weightBBRow = SharedPrefs.getWeightBBRow(getContext());
        if (weightBBRow < 48)
            warmup = "No warm up";
        else if (weightBBRow < 60)
            warmup = "(5 x 40)";
        else if (weightBBRow < 70)
            warmup = "(5 x 60)";
        else
            warmup = "Expand this app.";

        return warmup;
    }

    private String getPullupWarmUp() {
        return "No warm up";
    }
}