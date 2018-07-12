package com.example.bsobe.android_watch.splash_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.bsobe.android_watch.MainActivity;
import com.example.bsobe.android_watch.R;
import com.example.bsobe.android_watch.retrofit.CurrencyResources;

import java.util.List;

/**
 * Created by bsobe on 10.07.2018.
 */

public class SplashScreen extends Activity implements SplashScreenView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

    @Override
    public void setItems(List<CurrencyResources> items) {

    }

    @Override
    public void initParam() {

    }
}
