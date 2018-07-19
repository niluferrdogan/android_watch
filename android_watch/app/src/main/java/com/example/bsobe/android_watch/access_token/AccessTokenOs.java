package com.example.bsobe.android_watch.access_token;

/**
 * Created by Nilufer on 17.07.2018.
 */

public class AccessTokenOs {
    String family;

    public AccessTokenOs(String family, String version) {
        this.family = family;
        this.version = version;
    }

    String version;

    public AccessTokenOs() {

    }
}
