package com.android.stronk.fragments.push1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.stronk.activity.SharedPrefs;

import info.androidhive.stronk.R;


public class Push1WarmUp extends Fragment {

    public Push1WarmUp() {
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
        View view = inflater.inflate(R.layout.fragment_push1_warmup, container, false);

        TextView tvBenchPressWeight = (TextView) view.findViewById(R.id.tvBenchPressWeight);
        TextView tvOHPressWeight = (TextView) view.findViewById(R.id.tvOHPressWeight);
        TextView tvInclineDBWeight = (TextView) view.findViewById(R.id.tvInclineDBPressWeight);
        TextView tvOHLatWeight = (TextView) view.findViewById(R.id.tvOHLatWeight);

        tvBenchPressWeight.setText(getBenchPressWarmUp());
        tvOHPressWeight.setText(getOHPressWarmUp());
        tvInclineDBWeight.setText("No warm up");
        tvOHLatWeight.setText("No warm up");

        // Inflate the layout for this fragment
        return view;
    }

    private String getBenchPressWarmUp() {
        String warmup;
        double weightBenchPress = SharedPrefs.getWeightBenchPress(getContext());
        if (weightBenchPress < 30)
            warmup = "No warm up.";
        else if (weightBenchPress < 40)
            warmup = "(5 x 20) & (5 x 20)";
        else if (weightBenchPress < 50)
            warmup = "(5 x 20) & (5 x 20) & (5 x 30)";
        else if (weightBenchPress < 60)
            warmup = "(5 x 20) & (5 x 20) & (5 x 35)";
        else if (weightBenchPress < 70)
            warmup = "(5 x 20) & (5 x 20) & (5 x 40) & (5 x 50)";
        else if (weightBenchPress < 80)
            warmup = "(5 x 20) & (5 x 20) & (5 x 40) & (5 x 55)";
        else if (weightBenchPress < 90)
            warmup = "(5 x 20) & (5 x 20) & (5 x 40) & (5 x 60) & (5 x 70)";
        else
            warmup = "Expand this app.";

        return warmup;
    }

    private String getOHPressWarmUp() {
        String warmup;
        double weightOHPress = SharedPrefs.getWeightOHPress(getContext());
        if (weightOHPress < 30)
            warmup = "No warm up.";
        else if (weightOHPress < 40)
            warmup = "(5 x 20) & (5 x 20)";
        else if (weightOHPress < 50)
            warmup = "(5 x 20) & (5 x 20) & (5 x 30)";
        else if (weightOHPress < 60)
            warmup = "(5 x 20) & (5 x 20) & (5 x 35)";
        else if (weightOHPress < 70)
            warmup = "(5 x 20) & (5 x 20) & (5 x 40) & (5 x 50)";
        else if (weightOHPress < 80)
            warmup = "(5 x 20) & (5 x 20) & (5 x 40) & (5 x 55)";
        else if (weightOHPress < 90)
            warmup = "(5 x 20) & (5 x 20) & (5 x 40) & (5 x 60) & (5 x 70)";
        else
            warmup = "Expand this app.";

        return warmup;
    }

}
