package edu.sdu.kz.baseapplication.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public  class NetworkUtils {
    public static NetworkUtils INSTANCE;

    private final ConnectivityManager cm;

    private NetworkUtils(Context context){
        this.cm=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public static void createInstance(Context context){
        INSTANCE=new NetworkUtils(context);
    }

    public boolean isNetworkConnected() {
        if (cm==null) {
            return false;
        }
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();

    }
}

