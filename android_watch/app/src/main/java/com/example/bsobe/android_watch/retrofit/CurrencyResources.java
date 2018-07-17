package com.example.bsobe.android_watch.retrofit;

import com.example.bsobe.android_watch.Currencies;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nilufer on 9.07.2018.
 */

public class CurrencyResources {

    String expiresIn;
    Currencies[] currencies;

    public Currencies[] getCurrencies() { return currencies;    }

}
