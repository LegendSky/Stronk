package com.android.stronk.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import info.androidhive.stronk.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private Button btnPull1, btnPull2, btnPush1, btnPush2, btnLegs1, btnLegs2, btnProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPull1 = (Button) findViewById(R.id.btnPull1);
        btnPull2 = (Button) findViewById(R.id.btnPull2);
        btnPush1 = (Button) findViewById(R.id.btnPush1);
        btnPush2 = (Button) findViewById(R.id.btnPush2);
        btnLegs1 = (Button) findViewById(R.id.btnLegs1);
        btnLegs2 = (Button) findViewById(R.id.btnLegs2);
        btnProgress = (Button) findViewById(R.id.btnProgress);

        // Set click listeners.
        btnPull1.setOnClickListener(this);
        btnPull2.setOnClickListener(this);
        btnPush1.setOnClickListener(this);
        btnPush2.setOnClickListener(this);
        btnLegs1.setOnClickListener(this);
        btnLegs2.setOnClickListener(this);
        btnProgress.setOnClickListener(this);
    }

    /**
     * Add activities to buttons.
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPull1:
                startActivity(new Intent(MainActivity.this, Pull1Activity.class));
                break;
            case R.id.btnPush1:
                startActivity(new Intent(MainActivity.this, Push1Activity.class));
                break;
            case R.id.btnLegs1:
            case R.id.btnLegs2:
                startActivity(new Intent(MainActivity.this, LegsActivity.class));
                break;
            case R.id.btnPull2:
                startActivity(new Intent(MainActivity.this, Pull2Activity.class));
                break;
            case R.id.btnPush2:
                startActivity(new Intent(MainActivity.this, Push2Activity.class));
                break;
            case R.id.btnProgress:
                startActivity(new Intent(MainActivity.this, Progress.class));
                break;
        }
    }
}
