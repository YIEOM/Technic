package yieom.javastudy.technic.utils;

import android.util.Log;

import yieom.javastudy.technic.App;
import yieom.javastudy.technic.BuildConfig;

public class GeneralUtil {
    public static void printLog(String tag, String method, String msg, String value) {
        if (BuildConfig.DEBUG) Log.d(tag,method+", "+msg+" : "+value);
    }

    public static String getString(int id) {
        return App.getContext().getString(id);
    }
}
