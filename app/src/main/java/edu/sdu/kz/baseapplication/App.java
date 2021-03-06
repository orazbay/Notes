package edu.sdu.kz.baseapplication;

import android.app.Application;
import android.util.Log;

import edu.sdu.kz.baseapplication.data.prefs.PreferencesHelper;
import edu.sdu.kz.baseapplication.utils.NetworkUtils;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("app","onCreate");
        PreferencesHelper.createInstance(this);
        NetworkUtils.createInstance(this);
    }
}
