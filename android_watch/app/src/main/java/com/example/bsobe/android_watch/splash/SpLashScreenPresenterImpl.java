package com.example.bsobe.android_watch.splash;

/**
 * Created by Nilufer on 17.07.2018.
 */

public class SpLashScreenPresenterImpl implements SplashScreenPresenter{
    SplashScreenView splashScreenView;

    public SpLashScreenPresenterImpl(SplashScreenView splashScreenView) {
        this.splashScreenView = splashScreenView;
    }

    @Override
    public void initParameters() {
        if (splashScreenView != null) {
            splashScreenView.initParam();
        }
    }

    @Override
    public void setScreen() {
        splashScreenView.startSplash();

    }
}
