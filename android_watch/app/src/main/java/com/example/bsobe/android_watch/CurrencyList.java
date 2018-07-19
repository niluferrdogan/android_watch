package com.example.bsobe.android_watch;

/**
 * Created by Nilufer on 18.07.2018.
 */

public class CurrencyList {
    private String currencyName;
    private String buyPrice;
    private String sellPrice;

    public CurrencyList(String currencyName, String buyPrice, String sellPrice) {
        this.currencyName=currencyName;
        this.buyPrice=buyPrice;
        this.sellPrice=sellPrice;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }
}
