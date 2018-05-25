package edu.sdu.kz.baseapplication.data.network;

import android.content.Context;
import android.util.Log;

import java.io.IOException;

import edu.sdu.kz.baseapplication.utils.NetworkUtils;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by orazbay on 4/4/18.
 */

public class RetrofitHelper {
    private static String BASE_URL="https://api.backendless.com/DA9394F4-51F3-338A-FFCE-C11B76BBAD00/CF9C4B85-358A-3B34-FF0D-AE9952DC3200/";

    private static Retrofit retrofit;

    private static Retrofit getRetrofit(){
        if (retrofit==null){
            retrofit=createRetrofit();

            return retrofit;
        }
        return retrofit;
    }

    private static Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(createOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static OkHttpClient createOkHttpClient() {
        final OkHttpClient.Builder httpClient =
                new OkHttpClient.Builder();
        httpClient.addInterceptor(new ConnectivityInterceptor());
        httpClient.addInterceptor(chain -> {
            final Request original = chain.request();


            //base header,which must be in every request
            final Request.Builder requestBuilder = original.newBuilder()
                    .header("Content-Type","application/json");



            final Request request = requestBuilder.build();

            long t1 = System.nanoTime();
            Log.e("request", String.format("%s | %s",
                    request.url(),request.headers()));

            Response response = chain.proceed(request);

            long t2 = System.nanoTime();



//            return response.newBuilder().build();
            ResponseBody body = response.body();
            String bodyString = body.string();
            MediaType contentType = body.contentType();

            Log.e("response", String.format("Received %s from %s in %.1fms%n",bodyString,request.url(), (t2 - t1) / 1e6d));
            return response.newBuilder().body(ResponseBody.create(contentType, bodyString)).build();

        });

        return httpClient.build();
    }

    public static<T> T getService(Class<T> serviceClass){
        return getRetrofit().create(serviceClass);
    }






}
