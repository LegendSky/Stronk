package com.android.stronk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import info.androidhive.stronk.R;

/**
 * Created by Simin on 26-9-2015.
 */
public class SharedPrefs extends Activity implements View.OnClickListener {

    private EditText editText;
    private TextView tvDeadliftWeight;

    public static final String fileName = "preferences";

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
        tvDeadliftWeight = (TextView) findViewById(R.id.tvDeadliftWeight);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    public static void setWeightDeadlift(Context context, int number) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("deadlift", number);
        editor.commit();
    }

    public static int getWeightDeadlift(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("deadlift", 0);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        switch (v.getId()) {
            case R.id.btnSave:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                try {
                    int input = Integer.parseInt(editText.getText().toString());
                    editor.putInt("deadlift", input);
                } catch (NumberFormatException  e){

                }
                editor.commit();
                tvDeadliftWeight.setText(Integer.toString(getWeightDeadlift(this)));
                break;

            case R.id.btnLoad:
                tvDeadliftWeight.setText(Integer.toString(getWeightDeadlift(this)));
                break;
        }
    }
}
