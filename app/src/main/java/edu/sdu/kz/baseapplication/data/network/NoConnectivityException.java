package edu.sdu.kz.baseapplication.data.network;

import java.io.IOException;

public class NoConnectivityException extends IOException {

    @Override
    public String getMessage() {
        return "No connectivity exception";
    }

}