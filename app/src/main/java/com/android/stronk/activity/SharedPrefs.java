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

    //private static String fileName = "Shared Preferences";
    private static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_preferences);
        setupVariables();

        //sharedPreferences = getSharedPreferences(fileName, 0);
        sharedPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        //sharedPreferences = getSharedPreferences("preferences", Activity.MODE_PRIVATE);
        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(fileName);
    }

    public void load(View view) {
        sharedPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
    }

    private void setupVariables() {
        Button save = (Button) findViewById(R.id.btnSave);
        Button load = (Button) findViewById(R.id.btnLoad);
        sharedData = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    public static void setWeightDeadlift(SharedPreferences preferences, int number) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //editor.clear();
        editor.putInt("deadlift", number);
        editor.commit();
    }

    public static int getWeightDeadlift() {
        return sharedPreferences.getInt("deadlift", 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                int input = Integer.parseInt(sharedData.getText().toString());
                //editor.clear();
                editor.putInt("deadlift", input);
                editor.commit();
                textView.setText("Deadlift: " + getWeightDeadlift());
                break;

            case R.id.btnLoad:
                //sharedPreferences = getSharedPreferences(fileName, 0);
                String dataReturned = sharedPreferences.getString("preferences", "Couldn't load data");
                textView.setText(dataReturned);
                break;
        }
    }
}
