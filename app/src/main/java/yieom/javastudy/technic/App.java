package yieom.javastudy.technic;

import android.app.Application;
import android.content.Context;

import java.lang.ref.WeakReference;

import yieom.javastudy.technic.utils.GeneralUtil;

public class App extends Application {
    private String TAG = getClass().getName();

    private static WeakReference<Context> sContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = new WeakReference<>(getApplicationContext());
        GeneralUtil.printLog(TAG,"onCreate","context",sContext.get().toString());
    }

    public static Context getContext() {
        return sContext.get();
    }
}
