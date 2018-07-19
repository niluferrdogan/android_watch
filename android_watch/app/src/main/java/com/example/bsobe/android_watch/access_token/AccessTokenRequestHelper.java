package com.example.bsobe.android_watch.access_token;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * Created by Nilufer on 17.07.2018.
 */

public class AccessTokenRequestHelper {

    public AccesTokenRequest generateStartAppRequest(String localeVersion, String appVersion) {
        AccesTokenRequest startAppRequest = new AccesTokenRequest();
        startAppRequest.localeVersion = "Lv4gNYeY07PNA375o5MhaMmxVJyOSkKphS7AgFN4a8M";
        startAppRequest.device = generateDeviceInformation();
        startAppRequest.appVersion = "1.0";
        return startAppRequest;
    }

    private static AccessTokenDevice generateDeviceInformation() {
        AccessTokenDevice deviceInformation = new AccessTokenDevice();
        deviceInformation.make = Build.MANUFACTURER;
        deviceInformation.model = Build.MODEL;
        deviceInformation.os = getDeviceOS();
        return deviceInformation;
    }

    private static AccessTokenOs getDeviceOS() {
        AccessTokenOs deviceOS = new AccessTokenOs();
        deviceOS.family = "Android";
        deviceOS.version = ""+Build.VERSION.SDK_INT;
        return deviceOS;
    }

    public static String getAppVersion(Context context){
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

}
