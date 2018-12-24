package net.zahrauniversity.zahrauniversity.App;

import android.content.Context;
import android.content.SharedPreferences;

public class SpHelper {
    private final static String PREF_FILE = "zahra-pref";
    private final static String IS_LOGIN = "is_login";
    private final static String ACCESS_TOKEN = "access_token";
    private final static String ACCOUNT_TYPE = "account_type";
    private final static String STUDENT = "student";
    private final static String ADMIN = "admin";

    private final static String PHOTOS = "photos";
    private final static String UPDATES = "updates";
    private final static String VIDEOS = "videos";


    /**
     * Set a string shared preference
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    static void setSharedPreferenceString(Context context, String key, String value){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Set a integer shared preference
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    static void setSharedPreferenceInt(Context context, String key, int value){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void setPhotoTotal(Context context, int value){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(PHOTOS, value);
        editor.apply();
    }

    public static int getPhotoTotal(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        return settings.getInt(PHOTOS, 0);
    }

    public static void setUpdateTotal(Context context, int value){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(UPDATES, value);
        editor.apply();
    }

    public static int getUpdateTotal(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        return settings.getInt(UPDATES, 0);
    }

    public static void setVideoTotal(Context context, int value){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(VIDEOS, value);
        editor.apply();
    }

    public static int getVideoTotal(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        return settings.getInt(VIDEOS, 0);
    }

    /**
     * Set a Boolean shared preference
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    static void setSharedPreferenceBoolean(Context context, String key, boolean value){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * Get a string shared preference
     * @param key - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    static String getSharedPreferenceString(Context context, String key, String defValue){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        return settings.getString(key, defValue);
    }

    /**
     * Get a integer shared preference
     * @param key - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    static int getSharedPreferenceInt(Context context, String key, int defValue){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        return settings.getInt(key, defValue);
    }

    /**
     * Get a boolean shared preference
     * @param key - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    static boolean getSharedPreferenceBoolean(Context context, String key, boolean defValue){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        return settings.getBoolean(key, defValue);
    }

    public static boolean isLogin(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        return settings.getBoolean(IS_LOGIN, false) && settings.contains(ACCESS_TOKEN);
    }

    // this method return true if login with student
    // or false if login with admin

    public static boolean hasLoginStudent(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        String account_type = settings.getString(ACCOUNT_TYPE, STUDENT);
        return account_type.equals(STUDENT);
    }

    public static String getLocalToken(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        return "Bearer " + settings.getString(ACCESS_TOKEN ,"");

    }

    public static void makeAdminLogin(Context context, String access_token){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(IS_LOGIN, true);
        editor.apply();
        editor.putString(ACCESS_TOKEN, access_token);
        editor.apply();
        editor.putString(ACCOUNT_TYPE, ADMIN);
        editor.apply();
    }

    public static void makeStudentLogin(Context context, String access_token){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(IS_LOGIN, true);
        editor.apply();
        editor.putString(ACCESS_TOKEN, access_token);
        editor.apply();
        editor.putString(ACCOUNT_TYPE, STUDENT);
        editor.apply();
    }

    public static void destroyLogin(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(IS_LOGIN, false);
        editor.apply();

        editor.remove(ACCESS_TOKEN);
        editor.remove(ACCOUNT_TYPE);
        editor.apply();
    }






}
