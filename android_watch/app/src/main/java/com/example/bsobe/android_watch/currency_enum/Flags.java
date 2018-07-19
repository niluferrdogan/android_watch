package com.example.bsobe.android_watch.currency_enum;

import com.example.bsobe.android_watch.R;

/**
 * Created by bsobe on 10.07.2018.
 */

public enum Flags {

    usd("AmericanDollar",R.drawable.flag_usd),
    gbp("PoundSterling",R.drawable.gbp_copy),
    aud("AustrallianDollar", R.drawable.flag_aud),
    cad("CanadianDollar", R.drawable.flag_cad),
    chf("SwissFranc", R.drawable.flag_chf),
    dkk("DanishCrone", R.drawable.flag_dkk),
    eur("Euro", R.drawable.flag_eur),
    jpy("JapaneseYen", R.drawable.flag_jpy),
    nok("NokiaOyj", R.drawable.flag_nok),
    rub("RussianRuble", R.drawable.flag_rub),
    sek("SwedishKrona", R.drawable.flag_sek),
    xag("CFPFranc", R.drawable.flag_xag),
    xau("PhiladelphiaGoldAndSilver", R.drawable.flag_xau);

    private String name;
    private int image;

    private Flags(String name,int drawableId) {
        this.name = name;
        this.image=drawableId;
    }
    public int getImage(){
        return image;
    }
}
