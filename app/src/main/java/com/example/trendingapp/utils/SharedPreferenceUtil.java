package com.example.trendingapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.securepreferences.SecurePreferences;

import java.util.Set;

public final class SharedPreferenceUtil {
    // Constants for Keys

    public static final String DOMAIN_URL = "DOMAIN_URL";
    public static final String DISABLE_SSL_PINNIG = "DISABLE_SSL_PINNIG";
    public static final String AUTHORIZATION_TOKEN = "AUTHORIZATION_TOKEN";
    public static final String LOCATION_LATITUDE = "LATITUDE";
    public static final String LOCATION_LONGITUDE = "LONGITUDE";

    // Util functions
    private static SharedPreferences preferences;

    public SharedPreferenceUtil() {
    }

    private static SharedPreferences getPreferences(Context context) {
        if (preferences == null) {
            preferences = new SecurePreferences(context,
                    ConfigUtil.SHARED_PREFERENCES_PASSWORD,
                    ConfigUtil.SHARED_PREFERENCES_FILE_NAME);
        }
        return preferences;
    }

    // Getters
    public static String getStringSharedPreference(Context context, String key) {
        return getPreferences(context).getString(key, "");
    }

    public static boolean getBooleanSharedPreference(Context context, String key) {
        return getPreferences(context).getBoolean(key, false);
    }

    public static int getIntSharedPreference(Context context, String key) {
        return getPreferences(context).getInt(key, -1);
    }

    public static long getLongSharedPreference(Context context, String key) {
        return getPreferences(context).getLong(key, -1);
    }

    public static float getFloatSharedPreference(Context context, String key) {
        return getPreferences(context).getFloat(key, -1);
    }

    public static Set<String> getStringSetSharedPreference(Context context, String key) {
        return getPreferences(context).getStringSet(key, null);
    }


    // Setters
    public static void setSharedPreference(Context context, String key, String value) {
        SharedPreferences.Editor edit = getPreferences(context).edit();
        edit.putString(key, value);
        edit.apply();
    }

    public static void setSharedPreference(Context context, String key, boolean value) {
        SharedPreferences.Editor edit = getPreferences(context).edit();
        edit.putBoolean(key, value);
        edit.apply();
    }

    public static void setSharedPreference(Context context, String key, int value) {
        SharedPreferences.Editor edit = getPreferences(context).edit();
        edit.putInt(key, value);
        edit.apply();
    }

    public static void setSharedPreference(Context context, String key, long value) {
        SharedPreferences.Editor edit = getPreferences(context).edit();
        edit.putLong(key, value);
        edit.apply();
    }

    public static void setSharedPreference(Context context, String key, float value) {
        SharedPreferences.Editor edit = getPreferences(context).edit();
        edit.putFloat(key, value);
        edit.apply();
    }

    public static void setSharedPreference(Context context, String key, Set<String> value) {
        SharedPreferences.Editor edit = getPreferences(context).edit();
        edit.putStringSet(key, value);
        edit.apply();
    }

    public static void remove(Context context, String key) {
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.remove(key);
        prefsEditor.apply();
    }

    public static void setSharedPrefObject(Context context, Object object){
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(object);
        prefsEditor.putString("customer_details", json);
        prefsEditor.apply();
    }

    //Existing SharedPreferenceUtil does not work for remove hence this
    public static void removeAppPermissions(String key, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key);
        editor.clear();
        editor.apply();
    }
}
