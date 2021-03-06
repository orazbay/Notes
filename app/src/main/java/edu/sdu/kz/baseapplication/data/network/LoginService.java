package edu.sdu.kz.baseapplication.data.network;

import edu.sdu.kz.baseapplication.data.network.models.SignInRequest;
import edu.sdu.kz.baseapplication.data.network.models.SignInResponse;
import edu.sdu.kz.baseapplication.data.network.models.SignUpRequest;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface LoginService {

    @POST("users/login")
    Single<SignInResponse> signIn(
            @Body SignInRequest signInRequest
            );
    @GET("users/logout")
    Single<Object> signOut(
            @Header("user-token") String user_token
    );
    @POST("users/register")
    Single<SignInResponse> signUp(
            @Body SignUpRequest signUpRequest
    );
}
