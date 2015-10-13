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

    public static final String BENCH_PRESS_PREF = "benchpress";
    public static final String BENCH_PRESS_3X8_PREF = "benchpress3x8";
    public static final String OH_PRESS_PREF = "ohpress";
    public static final String OH_PRESS_3X8_PREF = "ohpress";
    public static final String INCLINE_DB_PREF = "inclinedb";
    public static final String OH_LAT_PREF = "ohlat";

    public static final String BB_ROW_PREF = "ohlat";

    public static void setWeightDeadlift(Context context, double weight) {
        setWeight(context, weight, DEADLIFT_PREF);
    }

    public static void setWeightPullUp(Context context, double weight) {
        setWeight(context, weight, PULLUP_PREF);
    }

    public static void setWeightHammerCurl(Context context, double weight) {
        setWeight(context, weight, HAMMERCURL_PREF);
    }

    public static void setWeightDBCurl(Context context, double weight) {
        setWeight(context, weight, DBCURL_PREF);
    }

    public static void setWeightBenchPress5x5(Context context, double weight) {
        setWeight(context, weight, BENCH_PRESS_PREF);
    }

    public static void setWeightBenchPress3x8(Context context, double weight) {
        setWeight(context, weight, BENCH_PRESS_3X8_PREF);
    }

    public static void setWeightOHPress5x5(Context context, double weight) {
        setWeight(context, weight, OH_PRESS_PREF);
    }

    public static void setWeightOHPress3x8(Context context, double weight) {
        setWeight(context, weight, OH_PRESS_3X8_PREF);
    }

    public static void setWeightInclineDBPress(Context context, double weight) {
        setWeight(context, weight, INCLINE_DB_PREF);
    }

    public static void setWeightOHLat(Context context, double weight) {
        setWeight(context, weight, OH_LAT_PREF);
    }

    public static void setWeightBBRow(Context context, double weight) {
        setWeight(context, weight, BB_ROW_PREF);
    }

    private static void setWeight(Context context, double weight, String pref) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(pref, Double.doubleToRawLongBits(weight));
        editor.commit();
    }

    public static double getWeightDeadlift(Context context) {
        return getWeight(context, DEADLIFT_PREF);
    }

    public static double getWeightPullUp(Context context) {
        return getWeight(context, PULLUP_PREF);
    }

    public static double getWeightHammerCurl(Context context) {
        return getWeight(context, HAMMERCURL_PREF);
    }

    public static double getWeightDBCurl(Context context) {
        return getWeight(context, DBCURL_PREF);
    }

    public static double getWeightBenchPress5x5(Context context) {
        return getWeight(context, BENCH_PRESS_PREF);
    }

    public static double getWeightBenchPress3x8(Context context) {
        return getWeight(context, BENCH_PRESS_3X8_PREF);
    }

    public static double getWeightOHPress5x5(Context context) {
        return getWeight(context, OH_PRESS_PREF);
    }

    public static double getWeightOHPress3x8(Context context) {
        return getWeight(context, OH_PRESS_3X8_PREF);
    }

    public static double getWeightInclineDB(Context context) {
        return getWeight(context, INCLINE_DB_PREF);
    }

    public static double getWeightOHLat(Context context) {
        return getWeight(context, OH_LAT_PREF);
    }

    public static double getWeightBBRow(Context context) {
        return getWeight(context, BB_ROW_PREF);
    }

    private static double getWeight(Context context, String pref) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return Double.longBitsToDouble(sharedPreferences.getLong(pref, 0));
    }
}
