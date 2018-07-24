package com.example.bsobe.android_watch.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bsobe.android_watch.Currencies;
import com.example.bsobe.android_watch.CurrencyList;
import com.example.bsobe.android_watch.Header;
import com.example.bsobe.android_watch.R;
import com.example.bsobe.android_watch.retrofit.CurrencyResources;

import java.util.ArrayList;

import com.example.bsobe.android_watch.customviews.MdCurrencyListView;

/**
 * Created by bsobe on 9.07.2018.
 */

public class CurrencyRecyclerAdapter  extends RecyclerView.Adapter<CurrencyRecyclerAdapter.ViewHolder> {

    private ArrayList<CurrencyList> currencyResources = new ArrayList<>();
    private Context mContext;
    private Header mHeader;

    public CurrencyRecyclerAdapter(ArrayList<CurrencyList> currencyResources, Context context) {
        mContext = context;
        this.currencyResources = currencyResources;
    }

    @Override
    public CurrencyRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);

            return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CurrencyRecyclerAdapter.ViewHolder holder, int position) {
        holder.bindPharmacy(currencyResources.get(position));
    }

    @Override
    public int getItemCount() {
        return currencyResources.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        MdCurrencyListView mdCurrencyListView;

        private Context mContext;

        public ViewHolder(View itemView) {
            super(itemView);
            mdCurrencyListView = (MdCurrencyListView) itemView.findViewById(R.id.md_currency_view);

            mContext = itemView.getContext();

        }

        public void bindPharmacy(CurrencyList currencyList) {
            mdCurrencyListView.setUiParameter(currencyList);
        }


    }
}