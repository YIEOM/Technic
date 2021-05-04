package yieom.javastudy.xmltechnic.utils;

import android.util.Log;

import yieom.javastudy.xmltechnic.AppModule;
import yieom.javastudy.xmltechnic.BuildConfig;

public class GeneralUtil {
    public static void printLog(String tag, String method, String msg, String value) {
        if (BuildConfig.DEBUG) Log.d(tag,method+", "+msg+" : "+value);
    }

    public static String getString(int id) {
        return AppModule.provideContext().getString(id);
    }
}
