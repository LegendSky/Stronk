package com.android.stronk.activity;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Simin on 26-9-2015.
 */
public class SharedPrefs {

    public static final String FILE_NAME = "preferences";

    public static final String DEADLIFT_PREF = "deadlift";
    public static final String PULLUP_PREF = "pullup";
    public static final String HAMMERCURL_PREF = "hammercurl";
    public static final String DBCURL_PREF = "dbcurl";

    public static void setWeightDeadlift(Context context, double weight) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(DEADLIFT_PREF, Double.doubleToRawLongBits(weight));
        editor.commit();
    }

    public static void setWeightPullUp(Context context, double weight) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(PULLUP_PREF, Double.doubleToRawLongBits(weight));
        editor.commit();
    }

    public static void setWeightHammerCurl(Context context, double weight) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(HAMMERCURL_PREF, Double.doubleToRawLongBits(weight));
        editor.commit();
    }

    public static void setWeightDBCurl(Context context, double weight) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(DBCURL_PREF, Double.doubleToRawLongBits(weight));
        editor.commit();
    }

    public static double getWeightDeadlift(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return Double.longBitsToDouble(sharedPreferences.getLong(DEADLIFT_PREF, 0));
    }

    public static double getWeightPullUp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return Double.longBitsToDouble(sharedPreferences.getLong(PULLUP_PREF, 0));
    }

    public static double getWeightHammerCurl(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return Double.longBitsToDouble(sharedPreferences.getLong(HAMMERCURL_PREF, 0));
    }

    public static double getWeightDBCurl(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return Double.longBitsToDouble(sharedPreferences.getLong(DBCURL_PREF, 0));
    }
}
