package info.androidhive.materialtabs.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import info.androidhive.materialtabs.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private Button btnPull1, btnPull2, btnPush1, btnPush2, btnPrefs;

    private Ringtone ringtone;
    private Chronometer chronometer;

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
        btnPrefs = (Button) findViewById(R.id.btnPrefs);

        // Set click listeners.
        btnPull1.setOnClickListener(this);
        btnPull2.setOnClickListener(this);
        btnPush1.setOnClickListener(this);
        btnPush2.setOnClickListener(this);
        btnPrefs.setOnClickListener(this);

        //initPreferences();
    }

    public void initPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("preference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("deadlift", 1);
        editor.commit();
        System.out.println("Added 1 to deadlift");
    }

    /**
     * Add activities to buttons.
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPull1:
                startActivity(new Intent(MainActivity.this, Pull1Activity.class));
                break;
            case R.id.btnPull2:
                startActivity(new Intent(MainActivity.this, Pull2Activity.class));
                break;
            case R.id.btnPush1:
                startActivity(new Intent(MainActivity.this, Push1Activity.class));
                break;
            case R.id.btnPush2:
                startActivity(new Intent(MainActivity.this, Push2Activity.class));
                break;
            case R.id.btnPrefs:
                startActivity(new Intent(MainActivity.this, SharedPrefs.class));
                break;
        }
    }
}
