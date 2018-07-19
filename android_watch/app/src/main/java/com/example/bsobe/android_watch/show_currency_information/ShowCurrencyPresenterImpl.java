package com.example.bsobe.android_watch.show_currency_information;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.bsobe.android_watch.Currencies;

/**
 * Created by Nilufer on 19.07.2018.
 */

public class ShowCurrencyPresenterImpl implements ShowCurrencyPresenter {
    ShowCurrencyView showView;

    public ShowCurrencyPresenterImpl(ShowCurrencyView showView) {
        this.showView=showView;
    }

    @Override
    public void initParameter() {
        if (showView != null) {
            showView.initParam();
        }
        
    }
}
