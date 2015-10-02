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

    public static final String FILE_NAME = "preferences";

    public static final String DEADLIFT_PREF = "deadlift";
    public static final String PULLUP_PREF = "pullup";
    public static final String HAMMERCURL_PREF = "hammercurl";
    public static final String DBCURL_PREF = "dbcurl";

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
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(DEADLIFT_PREF, number);
        editor.commit();
    }

    public static void setWeightPullUp(Context context, int number) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PULLUP_PREF, number);
        editor.commit();
    }

    public static void setWeightHammerCurl(Context context, int number) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(HAMMERCURL_PREF, number);
        editor.commit();
    }

    public static void setWeightDBCurl(Context context, int number) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(DBCURL_PREF, number);
        editor.commit();
    }

    public static int getWeightDeadlift(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(DEADLIFT_PREF, 0);
    }

    public static int getWeightPullUp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(PULLUP_PREF, 0);
    }

    public static int getWeightHammerCurl(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(HAMMERCURL_PREF, 0);
    }

    public static int getWeightDBCurl(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(DBCURL_PREF, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                try {
                    int input = Integer.parseInt(editText.getText().toString());
                    setWeightDeadlift(this, input);
                } catch (NumberFormatException e) {
                    // Invalid number.
                }
                tvDeadliftWeight.setText(getWeightDeadlift(this));
                break;
        }
    }
}
