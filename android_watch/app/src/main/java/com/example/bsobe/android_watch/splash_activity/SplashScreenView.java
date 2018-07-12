package com.example.bsobe.android_watch.splash_activity;

import com.example.bsobe.android_watch.retrofit.CurrencyResources;

import java.util.List;

/**
 * Created by bsobe on 10.07.2018.
 */

public interface SplashScreenView {

    void setItems(List<CurrencyResources> items);

    void initParam();
}
