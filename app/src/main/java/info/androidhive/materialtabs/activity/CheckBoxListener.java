package info.androidhive.materialtabs.activity;

import android.media.Ringtone;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Chronometer;

/**
 * Created by Simin on 26-9-2015.
 */
public class CheckBoxListener implements View.OnClickListener {
    private CheckBox checkBox;
    private Chronometer chronometer;
    private Ringtone ringtone;

    public CheckBoxListener(Chronometer chronometer, Ringtone ringtone, CheckBox checkBox) {
        this.checkBox = checkBox;
        this.chronometer = chronometer;
        this.ringtone = ringtone;
    }

    @Override
    public void onClick(View v) {
        //Actions when the checkbox is checked.
        if (checkBox.isChecked()) {

            //Adds a tick listener to chronometer.
            chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

                //At 02:00, plays notification sound.
                @Override
                public void onChronometerTick(Chronometer chronometer) {
                    if (chronometer.getText().toString().equalsIgnoreCase("02:00")) {
                        ringtone.play();
                    }
                }
            });

            //Resets chronometer to 00:00.
            chronometer.setBase(SystemClock.elapsedRealtime());

            //Starts the chronometer.
            chronometer.start();

            //Actions for unchecked checkbox.
        } else {

            //Stops the chronometer.
            chronometer.stop();
        }
    }
}
