package com.example.bsobe.android_watch.main;

import android.content.Context;

import com.example.bsobe.android_watch.CurrencyList;

import java.util.List;

/**
 * Created by bsobe on 9.07.2018.
 */

public interface MainView {

    void showProgress();

    void hideProgress();

    void setItems(List<CurrencyList> items);

    void showMessage(String message);

    void initParam();

}
