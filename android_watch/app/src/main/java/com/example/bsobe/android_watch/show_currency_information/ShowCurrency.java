package com.example.bsobe.android_watch.show_currency_information;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bsobe.android_watch.CurrencyList;
import com.example.bsobe.android_watch.R;
import com.example.bsobe.android_watch.main.MainPresenterImpl;

/**
 * Created by Nilufer on 19.07.2018.
 */

public class ShowCurrency extends Activity implements ShowCurrencyView{

    String mCurrencyName;
    String mCurrencyLongName;
    Integer mImgCode;
    ShowCurrencyPresenterImpl showPresenter;
    TextView txtCurrName;
    TextView txtCurrLongName;
    TextView txtBuyingCost;
    ImageView imgCurrFlag;
    TextView txtSellingCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_currency_page);

        showPresenter= new ShowCurrencyPresenterImpl(this);
        showPresenter.initParameter();
        setCurrencyItems();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void initParam() {
        Bundle extras = getIntent().getExtras();
        mCurrencyName= extras.getString("curr_name");
        mCurrencyLongName=extras.getString("curr_long_name");
        mImgCode=extras.getInt("img_code");
        txtCurrName= findViewById(R.id.txt_currency_name);
        txtCurrLongName= findViewById(R.id.txt_tr_currency_name);
        imgCurrFlag= findViewById(R.id.img_logo);
        txtBuyingCost=findViewById(R.id.txt_buying_cost);
        txtSellingCost=findViewById(R.id.txt_selling_cost);
        findBuyandSellPrice();
    }

    @Override
    public void setCurrencyItems() {
        txtCurrName.setText(mCurrencyName);
        txtCurrLongName.setText(mCurrencyLongName);
        imgCurrFlag.setImageResource(mImgCode);
    }

    private void findBuyandSellPrice()  {
        for(int i=0;i< MainPresenterImpl.sCurrencyList.size();++i)  {
            CurrencyList tempList=MainPresenterImpl.sCurrencyList.get(i);
            if(tempList.getCurrencyName().toUpperCase().equals(mCurrencyName))
                txtBuyingCost.setText(tempList.getBuyPrice());
                txtSellingCost.setText(tempList.getSellPrice());
        }
    }
}
