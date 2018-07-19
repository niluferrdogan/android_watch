package com.example.bsobe.android_watch.customviews;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bsobe.android_watch.Currencies;
import com.example.bsobe.android_watch.CurrencyList;
import com.example.bsobe.android_watch.MainActivity;
import com.example.bsobe.android_watch.R;
import com.example.bsobe.android_watch.currency_enum.Flags;
import com.example.bsobe.android_watch.main.MainView;
import com.example.bsobe.android_watch.retrofit.CurrencyResources;
import com.example.bsobe.android_watch.show_currency_information.ShowCurrency;
import com.example.bsobe.android_watch.splash.SplashScreen;

import java.util.List;

import butterknife.OnClick;

/**
 * Created by bsobe on 9.07.2018.
 */

public class MdCurrencyListView  extends LinearLayout {

    private Context mContext;
    TextView txtCurrName;
    TextView txtCurrLongName;
    ImageView imgCurrFlag;
    int imgCode;

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

        txtCurrName = findViewById(R.id.txt_curr_name);
        txtCurrLongName = findViewById(R.id.txt_long_curr_name);
        imgCurrFlag= findViewById(R.id.img_currencyFlag);

        mContext = context;

        LinearLayout ll= findViewById(R.id.layout_custom_view);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ShowCurrency.class);
                intent.putExtra("curr_name",txtCurrName.getText());
                intent.putExtra("curr_long_name",txtCurrLongName.getText());
                intent.putExtra("img_code",imgCode);
                mContext.startActivity(intent);
            }
        });

    }

    public void  setUiParameter(CurrencyList currencyList) {
        String currName=currencyList.getCurrencyName().toUpperCase();
        txtCurrName.setText(currName);
        findCurrNameFlag(currName);
    }

    public void findCurrNameFlag(String currName)  {

        if(currName.equals("USD")) {
            txtCurrLongName.setText("Amerikan Doları");
            imgCode=Flags.usd.getImage();
            imgCurrFlag.setImageResource(imgCode);
        }

        if(currName.equals("AUD")) {
            txtCurrLongName.setText("Avustralya Doları");
            imgCode=Flags.aud.getImage();
            imgCurrFlag.setImageResource(imgCode);
        }
        else if (currName.equals("CAD")) {
            txtCurrLongName.setText("Kanada Doları");
            imgCode=Flags.cad.getImage();
            imgCurrFlag.setImageResource(imgCode);
        }
        else if (currName.equals("CHF")) {
            txtCurrLongName.setText("İsviçre Frankı");
            imgCode=Flags.dkk.getImage();
            imgCurrFlag.setImageResource(imgCode);
        }
        else if (currName.equals("DKK")) {
            txtCurrLongName.setText("Danimarka Kronu");
            imgCode=Flags.dkk.getImage();
            imgCurrFlag.setImageResource(imgCode);
        }
        else if (currName.equals("EUR")) {
            txtCurrLongName.setText("Euro");
            imgCode=Flags.eur.getImage();
            imgCurrFlag.setImageResource(imgCode);
        }
        else if (currName.equals("JPY")) {
            txtCurrLongName.setText("Japon Yeni");
            imgCode=Flags.jpy.getImage();
            imgCurrFlag.setImageResource(imgCode);
        }
        else if (currName.equals("NOK")) {
            txtCurrLongName.setText("Nokia Oyj");
            imgCode=Flags.nok.getImage();
            imgCurrFlag.setImageResource(imgCode);
        }
        else if (currName.equals("RUB")) {
            txtCurrLongName.setText("Rus Rublesi");
            imgCode=Flags.rub.getImage();
            imgCurrFlag.setImageResource(imgCode);
        }
        else if (currName.equals("SEK")) {
            txtCurrLongName.setText("İsveç Kronu");
            imgCode=Flags.sek.getImage();
            imgCurrFlag.setImageResource(imgCode);
        }
        else if (currName.equals("XAG")) {
            txtCurrLongName.setText("SFP Frank");
            imgCode=Flags.xag.getImage();
            imgCurrFlag.setImageResource(imgCode);
        }
        else if (currName.equals("XAU")) {
            txtCurrLongName.setText("Filedelfiya Altın ve Gümüşü");
            imgCode=Flags.xau.getImage();
            imgCurrFlag.setImageResource(imgCode);
        }
        else if (currName.equals("GBP")) {
            txtCurrLongName.setText("İngiliz Lirası");
            imgCode=Flags.gbp.getImage();
            imgCurrFlag.setImageResource(imgCode);
        }
    }
}
