package com.example.bsobe.android_watch;

import com.example.bsobe.android_watch.retrofit.CurrencyResources;

import java.util.List;

/**
 * Created by bsobe on 9.07.2018.
 */

public interface MainView {

    void showProgress();

    void hideProgress();

    void setItems(List<CurrencyResources> items);

    void showMessage(String message);

    void initParam();

}
