package com.example.bsobe.android_watch.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.bsobe.android_watch.MainActivity;
import com.example.bsobe.android_watch.R;

/**
 * Created by bsobe on 10.07.2018.
 */

public class SplashScreen extends Activity implements SplashScreenView{

    Thread mTimerThread;
    SplashScreenPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        mPresenter = new SpLashScreenPresenterImpl(this);
        mPresenter.initParameters();
        mPresenter.setScreen();

    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

    @Override
    public void initParam() {
        mTimerThread = new Thread(){
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
    }

    @Override
    public void startSplash() {
        mTimerThread.start();
    }
}
