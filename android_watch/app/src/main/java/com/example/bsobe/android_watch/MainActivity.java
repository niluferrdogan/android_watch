package com.example.bsobe.android_watch;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.wearable.activity.WearableActivity;
import android.widget.Toast;

import com.example.bsobe.android_watch.retrofit.CurrencyResources;

import java.util.ArrayList;
import java.util.List;

import com.example.bsobe.android_watch.adapters.CurrencyRecyclerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends WearableActivity implements MainView{

    private MainPresenter mPresenter;
    private CurrencyRecyclerAdapter mCurrencyRecyclerAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mPresenter = new MainPresenterImpl(this);
        mPresenter.initParameters();
        mPresenter.callCurrencyService();

        // Enables Always-on
        setAmbientEnabled();
    }

    @Override
    public void initParam() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setItems(List<CurrencyResources> items) {
        mCurrencyRecyclerAdapter = new CurrencyRecyclerAdapter((ArrayList<CurrencyResources>) items,this);
        recyclerView.setAdapter(mCurrencyRecyclerAdapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
