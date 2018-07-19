package com.example.bsobe.android_watch.show_currency_information;

import com.example.bsobe.android_watch.CurrencyList;

import java.util.List;

/**
 * Created by Nilufer on 19.07.2018.
 */

public interface ShowCurrencyView {
    void showProgress();

    void hideProgress();

    void initParam();

    public void setCurrencyItems();
}
