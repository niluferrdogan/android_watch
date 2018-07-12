package com.example.bsobe.android_watch.customviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bsobe.android_watch.R;
import com.example.bsobe.android_watch.retrofit.CurrencyResources;

/**
 * Created by bsobe on 9.07.2018.
 */

public class MdCurrencyListView  extends LinearLayout{

    private Context mContext;
    TextView name;
    TextView address;
    TextView phone;

    public MdCurrencyListView(Context context) {
        super(context);
        init(context);
    }

    public MdCurrencyListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MdCurrencyListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.currency_list_custom_view, this, true);

        name = findViewById(R.id.txt_name);
        address = findViewById(R.id.txt_adress);
        phone = findViewById(R.id.txt_phone);

        mContext = context;

    }

    public void setUiParameter(CurrencyResources currency) {
        name.setText(currency.adi);
        address.setText(currency.acikAdres);
        phone.setText(currency.telefon);
    }
}
