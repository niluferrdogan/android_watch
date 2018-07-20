package com.example.bsobe.android_watch.main;

import com.example.bsobe.android_watch.Currencies;
import com.example.bsobe.android_watch.CurrencyList;
import com.example.bsobe.android_watch.Destinations;
import com.example.bsobe.android_watch.access_token.AccesTokenRequest;
import com.example.bsobe.android_watch.access_token.AccessTokenRequestHelper;
import com.example.bsobe.android_watch.access_token.AccessTokenResponse;
import com.example.bsobe.android_watch.retrofit.APIClient;
import com.example.bsobe.android_watch.retrofit.APIInterface;
import com.example.bsobe.android_watch.retrofit.CurrencyResources;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Nilufer on 9.07.2018.
 */

public class MainPresenterImpl implements MainPresenter {
    private MainView mainView;

    private static String sToken;
    private Retrofit mRetrofit;
    private APIInterface mClient;
    public static List<CurrencyList> sCurrencyList;
    private static Currencies sBuyCurrency;
    private static Currencies sSellCurrency;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void initParameters() {
        if (mainView != null) {
            mainView.initParam();
        }
        sBuyCurrency=new Currencies();
        sSellCurrency=new Currencies();
    }

    @Override
    public void callCurrencyService() {
        mainView.showProgress();
        mRetrofit = APIClient.getRetrofitInstance();
        mClient = mRetrofit.create(APIInterface.class);

        AccessTokenRequestHelper accesTokenRequestHelper= new AccessTokenRequestHelper();
        AccesTokenRequest accesTokenRequest= accesTokenRequestHelper.generateStartAppRequest("1.0","aa");

        Call<AccessTokenResponse> call=mClient.getNewAccessToken(accesTokenRequest);

        call.enqueue(new Callback<AccessTokenResponse>() {
            @Override
            public void onResponse(Call<AccessTokenResponse> call, Response<AccessTokenResponse> response) {
                if(response.isSuccessful()) {
                    sToken= response.body().token;
                    callForBuy();

                }
            }

            @Override
            public void onFailure(Call<AccessTokenResponse> call, Throwable t) {
                mainView.showMessage("ERROR");
            }
        });

    }

    private void callForBuy()  {
        Call<CurrencyResources> callGet = mClient.doGetListResources("buy","TRY",sToken);

        callGet.enqueue(new Callback<CurrencyResources>() {
            @Override
            public void onResponse(Call<CurrencyResources> call, Response<CurrencyResources> response) {
                prepareDataForBuy(mClient,response.body());

            }

            @Override
            public void onFailure(Call<CurrencyResources> call, Throwable t) {
                call.cancel();
                mainView.showMessage("eerSSS");
            }
        });
    }

    private void callForSell(APIInterface client,Currencies buy)  {
        Call<CurrencyResources> callGet = client.doGetListResources("sell","TRY",sToken);

        callGet.enqueue(new Callback<CurrencyResources>() {
            @Override
            public void onResponse(Call<CurrencyResources> call, Response<CurrencyResources> response) {
                prepareDataForSell(buy,response.body());
            }

            @Override
            public void onFailure(Call<CurrencyResources> call, Throwable t) {
                call.cancel();
                mainView.showMessage("eerSSS2");
            }
        });
    }

    public void prepareDataForBuy(APIInterface client,CurrencyResources buyİtems)    {
        Currencies[]temp=buyİtems.getCurrencies();
        sBuyCurrency=new Currencies(temp[0].getDestinations());
        callForSell(client,sBuyCurrency);


    }

    public void prepareDataForSell(Currencies buy,CurrencyResources sellItems)    {
        Currencies[]temp=sellItems.getCurrencies();
        sSellCurrency=new Currencies(temp[0].getDestinations());
        new MainPresenterImpl(mainView).prepareDataForView(buy,sSellCurrency);


    }

    private void prepareDataForView(Currencies buy, Currencies sellItems) {

        ArrayList<CurrencyList> currList= new ArrayList<>();
        Destinations[] tempSellDest=sSellCurrency.getDestinations();
        Destinations[] tempBuyDest=buy.getDestinations();

        for(int i=0;i<tempSellDest.length;++i)  {
            CurrencyList tempList= new CurrencyList(tempSellDest[i].getCode(),tempSellDest[i].getValue(),tempBuyDest[i].getValue());
            currList.add(tempList);
        }

        sCurrencyList=currList;

        if (mainView != null) {
            mainView.setItems(currList);
            mainView.hideProgress();
        }

    }
    public MainView getMainView() {
        return mainView;
    }

}