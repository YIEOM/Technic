package yieom.javastudy.contentprovidera.utils;

import android.util.Log;

import yieom.javastudy.contentprovidera.AppModule;
import yieom.javastudy.contentprovidera.BuildConfig;

public class GeneralUtil {
    public static void printLog(String tag, String method, String msg, String value) {
        if (BuildConfig.DEBUG) Log.d(tag,method+", "+msg+" : "+value);
    }

    public static String getString(int id) {
        return AppModule.provideContext().getString(id);
    }
}
