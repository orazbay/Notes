package edu.sdu.kz.baseapplication.data.network;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface SomeService {

    @GET("getSomething")
    Single<BaseResponse> getSomething(
            @Header("Authorization") String auth
    );
    @POST("postSomething")
    Single<BaseResponse> postSomething(
            @Header("Authorization") String auth,
            @Query("someQuery") String someQuery
    );
}
