package info.androidhive.materialtabs.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import info.androidhive.materialtabs.R;

/**
 * Preference file, not used as of yet.
 * Created by Simin on 26-9-2015.
 */
public class SharedPrefs extends Activity implements View.OnClickListener {

    private EditText sharedData;
    private TextView dataResults;

    private TextView textView2;


    private static String fileName = "Shared Preferences";
    private static SharedPreferences sharedPreferences;

    public static int intensity1;
    public static int weightDeadlift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_preferences);
        setupVariables();

        textView2 = (TextView) findViewById(R.id.textView2);

        sharedPreferences = getSharedPreferences(fileName, 0);
    }

    private void setupVariables() {
        Button save = (Button) findViewById(R.id.btnSave);
        Button load = (Button) findViewById(R.id.btnLoad);
        sharedData = (EditText) findViewById(R.id.editText);
        dataResults = (TextView) findViewById(R.id.textView);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    public static void setWeightDeadlift(int number) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
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
                //String stringData = sharedData.getText().toString();
                //int intData = Integer.parseInt(sharedData.getText().toString());
                //SharedPreferences.Editor editor = sharedPreferences.edit();
                //editor.putString("shared preferences string", stringData);
                //editor.putInt("weight", intData);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                int input = Integer.parseInt(sharedData.getText().toString());
                editor.putInt("deadlift", input);
                editor.commit();

                textView2.setText("Deadlift: " + getWeightDeadlift());
                break;

            case R.id.btnLoad:
                sharedPreferences = getSharedPreferences(fileName, 0);
                String dataReturned = sharedPreferences.getString("shared preferences string", "Couldn't load data");
                dataResults.setText(dataReturned);
                break;
        }
    }
}
