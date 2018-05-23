package edu.sdu.kz.baseapplication.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignInResponse {
    public String ownerId;
    @SerializedName("user-token")
    public String user_token;


}
