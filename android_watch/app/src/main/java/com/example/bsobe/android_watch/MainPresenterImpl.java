package com.example.bsobe.android_watch;

import android.os.Handler;

import com.example.bsobe.android_watch.retrofit.APIClient;
import com.example.bsobe.android_watch.retrofit.APIInterface;
import com.example.bsobe.android_watch.retrofit.CurrencyResources;

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
    private Integer choosenCurrency;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onItemClicked(int position) {

        if (mainView != null) {
            mainView.showMessage(String.format("Position %d clicked", position + 1));
            choosenCurrency = position + 1;
        }
    }

    @Override
    public void initParameters() {
        if (mainView != null) {
            mainView.initParam();
        }
    }

    @Override
    public void callCurrencyService() {
        Retrofit retrofitObj = APIClient.getRetrofitInstance();
        APIInterface client = retrofitObj.create(APIInterface.class);
        Call<List<CurrencyResources>> call = client.doGetListResources();
        if (mainView != null) {
            mainView.showProgress();
        }
        call.enqueue(new Callback<List<CurrencyResources>>() {
            @Override
            public void onResponse(Call<List<CurrencyResources>> call, Response<List<CurrencyResources>> response) {
                new Handler().postDelayed(() -> prepareDataForView(response.body()), 2000);
            }

            @Override
            public void onFailure(Call<List<CurrencyResources>> call, Throwable t) {
                call.cancel();
                if (mainView != null) {
                    mainView.hideProgress();
                }
            }
        });

    }

    private void prepareDataForView(List<CurrencyResources> items) {

        if (mainView != null) {
            mainView.setItems(items);
            mainView.hideProgress();
        }
    }

    public MainView getMainView() {
        return mainView;
    }
}