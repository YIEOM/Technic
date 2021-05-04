package yieom.javastudy.contentprovidera;

import android.content.Context;

import java.lang.ref.WeakReference;

import yieom.javastudy.contentprovidera.utils.GeneralUtil;

public class AppModule {
    private String TAG = getClass().getName();
    private AppModule() {
    }

    private static class AppModuleHolder {
        private static final AppModule instance = new AppModule();
    }

    public static AppModule getInstance() {
        return AppModuleHolder.instance;
    }

    private static WeakReference<Context> sContext = null;

    public void init(Context context) {
        GeneralUtil.printLog(TAG,"setContext","start",context.toString());
        sContext = new WeakReference<>(context);
    }

    public static Context provideContext() {
        return sContext.get();
    }
}
