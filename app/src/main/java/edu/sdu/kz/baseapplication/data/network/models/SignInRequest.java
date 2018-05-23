package edu.sdu.kz.baseapplication.data.network.models;

public class SignInRequest {
    public String login,password;

    public SignInRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
