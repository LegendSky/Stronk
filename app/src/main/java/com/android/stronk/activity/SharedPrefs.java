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
 * Preference file, not used as of yet.
 * Created by Simin on 26-9-2015.
 */
public class SharedPrefs extends Activity implements View.OnClickListener {

    private EditText sharedData;
    private TextView textView;

    private static String fileName = "preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_preferences);
        setupVariables();
    }

    private void setupVariables() {
        Button save = (Button) findViewById(R.id.btnSave);
        Button load = (Button) findViewById(R.id.btnLoad);
        sharedData = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.tvDeadliftWeight);
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

    // TODO: Stop crash.
    @Override
    public void onClick(View v) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        switch (v.getId()) {
            case R.id.btnSave:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                int input = Integer.parseInt(sharedData.getText().toString());
                editor.putInt("deadlift", input);
                editor.commit();
                textView.setText(getWeightDeadlift(getApplicationContext()));
                break;

            case R.id.btnLoad:
                textView.setText(sharedPreferences.getInt("deadlift", 0));
                break;
        }
    }
}
