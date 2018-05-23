package edu.sdu.kz.baseapplication.data.network.models;

public class SignUpRequest {
    public String email,name,password;

    public SignUpRequest(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
