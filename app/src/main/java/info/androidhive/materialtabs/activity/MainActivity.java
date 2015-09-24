package info.androidhive.materialtabs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import info.androidhive.materialtabs.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private Button btnPull1, btnPull2, btnPush1, btnPush2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPull1 = (Button) findViewById(R.id.btnPull1);
        btnPull2 = (Button) findViewById(R.id.btnPull2);
        btnPush1 = (Button) findViewById(R.id.btnPush1);
        btnPush2 = (Button) findViewById(R.id.btnPush2);
        //btnCustomIconTextTabs = (Button) findViewById(R.id.btnCustomIconTabs);

        btnPull1.setOnClickListener(this);
        btnPull2.setOnClickListener(this);
        btnPush1.setOnClickListener(this);
        btnPush2.setOnClickListener(this);

        /*btnSimpleTabs.setOnClickListener(this);
        btnScrollableTabs.setOnClickListener(this);
        btnIconTextTabs.setOnClickListener(this);
        btnIconTabs.setOnClickListener(this);
        btnCustomIconTextTabs.setOnClickListener(this);*/

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPull1:
                startActivity(new Intent(MainActivity.this, SimpleTabsActivity.class));
                break;
            case R.id.btnPull2:
                startActivity(new Intent(MainActivity.this, ScrollableTabsActivity.class));
                break;
            case R.id.btnPush1:
                startActivity(new Intent(MainActivity.this, IconTextTabsActivity.class));
                break;
            case R.id.btnPush2:
                startActivity(new Intent(MainActivity.this, IconTabsActivity.class));
                break;
            /*case R.id.btnCustomIconTabs:
                startActivity(new Intent(MainActivity.this, CustomViewIconTextTabsActivity.class));
                break;*/
        }
    }
}
