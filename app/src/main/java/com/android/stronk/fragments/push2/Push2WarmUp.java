package com.android.stronk.fragments.push2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.stronk.activity.SharedPrefs;

import info.androidhive.stronk.R;


public class Push2WarmUp extends Fragment{

    public Push2WarmUp() {
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
        View view = inflater.inflate(R.layout.fragment_push2_warmup, container, false);

        TextView tvOHPressWeight = (TextView) view.findViewById(R.id.tvOHPressWeight);
        TextView tvBenchPressWeight = (TextView) view.findViewById(R.id.tvBenchPressWeight);
        TextView tvInclineDBWeight = (TextView) view.findViewById(R.id.tvInclineDBPressWeight);
        TextView tvOHLatWeight = (TextView) view.findViewById(R.id.tvOHLatWeight);

        tvOHPressWeight.setText(getOHPressWarmUp());
        tvBenchPressWeight.setText(getBenchPressWarmUp());
        tvInclineDBWeight.setText("No warm up");
        tvOHLatWeight.setText("No warm up");

        return view;
    }


    private String getBenchPressWarmUp() {
        String warmup;
        double weightBenchPress = SharedPrefs.getWeightBenchPress3x8(getContext());
        if (weightBenchPress < 30)
            warmup = "No warm up";
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
        double weightOHPress = SharedPrefs.getWeightOHPress5x5(getContext());
        if (weightOHPress < 30)
            warmup = "No warm up";
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
