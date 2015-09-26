package info.androidhive.materialtabs.activity;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Preference file, not used as of yet.
 * Created by Simin on 26-9-2015.
 */
public class SharedPrefs {
    public static String PREF_VALUE1 = "5";
    public static String PREF_VALUE2 = "value2";

    private static String prefsFileName = "prefs";
    private SharedPreferences prefs;

    public SharedPrefs(Context context) {
        prefs = context.getSharedPreferences(prefsFileName, Context.MODE_PRIVATE);
    }

    public SharedPreferences getPreferences() {
        return prefs;
    }
}
