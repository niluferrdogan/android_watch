package com.example.bsobe.android_watch;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bsobe.android_watch.main.MainPresenter;
import com.example.bsobe.android_watch.main.MainPresenterImpl;
import com.example.bsobe.android_watch.main.MainView;

import java.util.ArrayList;
import java.util.List;

import com.example.bsobe.android_watch.adapters.CurrencyRecyclerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends WearableActivity implements MainView {

    private MainPresenter mPresenter;
    private CurrencyRecyclerAdapter mCurrencyRecyclerAdapter;
    private ProgressBar mProgress;

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

        mProgress= findViewById(R.id.progress);
    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void setItems(List<CurrencyList> items) {
        mCurrencyRecyclerAdapter = new CurrencyRecyclerAdapter((ArrayList<CurrencyList>) items,this);
        recyclerView.setAdapter(mCurrencyRecyclerAdapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }



}
