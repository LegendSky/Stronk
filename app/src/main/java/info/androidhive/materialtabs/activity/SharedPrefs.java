package info.androidhive.materialtabs.activity;

import android.app.Activity;
import android.content.Context;
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
    private static String fileName = "Shared Preferences";
    private SharedPreferences someData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_preferences);
        setupVariables();
        someData = getSharedPreferences(fileName, 0);
    }

    private void setupVariables() {
        Button save = (Button) findViewById(R.id.btnSave);
        Button load = (Button) findViewById(R.id.btnLoad);
        sharedData = (EditText) findViewById(R.id.editText);
        dataResults = (TextView) findViewById(R.id.textView);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnSave:
                String stringData = sharedData.getText().toString();
                SharedPreferences.Editor editor = someData.edit();
                editor.putString("shared string", stringData);
                editor.commit();
                break;
            case R.id.btnLoad:
                someData = getSharedPreferences(fileName, 0);
                String dataReturned = someData.getString("shared string", "Couldn't load data");
                dataResults.setText(dataReturned);
                break;
        }
    }
}
