package com.example.bsobe.android_watch.access_token;

/**
 * Created by Nilufer on 17.07.2018.
 */

public class AccesTokenRequest {
    String appVersion;
    AccessTokenDevice device;
    String localeVersion;

    public AccesTokenRequest(String appVersion, AccessTokenDevice device, String localeVersion) {
        this.appVersion = appVersion;
        this.device = device;
        this.localeVersion = localeVersion;
    }

    public AccesTokenRequest() {

    }
}
