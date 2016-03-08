package com.android.stronk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import info.androidhive.stronk.R;

/**
 * Created by Simin on 26-9-2015.
 */
public class Progress extends Activity implements View.OnClickListener {

    private EditText editText;
    private TextView tvDeadliftWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_preferences);
        setupVariables();
    }

    private void setupVariables() {
        Button save = (Button) findViewById(R.id.btnSave);
        Button load = (Button) findViewById(R.id.btnLoad);
        editText = (EditText) findViewById(R.id.editText);
        tvDeadliftWeight = (TextView) findViewById(R.id.tvSquatWeight);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                try {
                    double input = Double.parseDouble(editText.getText().toString());
                    SharedPrefs.setWeightDeadlift(this, input);
                } catch (NumberFormatException e) {
                    // Invalid number.
                }
                tvDeadliftWeight.setText(Double.toString(SharedPrefs.getWeightDeadlift(this)));
                break;
        }
    }
}
