package edu.sdu.kz.baseapplication.data.network;

import java.io.IOException;

import edu.sdu.kz.baseapplication.utils.NetworkUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ConnectivityInterceptor implements Interceptor {



    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!NetworkUtils.INSTANCE.isNetworkConnected()) {
            throw new NoConnectivityException();
        }

        Request.Builder builder = chain.request().newBuilder();
        return chain.proceed(builder.build());
    }

}