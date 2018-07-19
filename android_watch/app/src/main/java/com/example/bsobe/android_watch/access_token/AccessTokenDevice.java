package com.example.bsobe.android_watch.access_token;

/**
 * Created by Nilufer on 17.07.2018.
 */

public class AccessTokenDevice {
    String make;
    String model;
    AccessTokenOs os;

    public AccessTokenDevice(String make, String model, AccessTokenOs os) {
        this.make = make;
        this.model = model;
        this.os = os;
    }

    public AccessTokenDevice() {

    }
}
