package com.example.bsobe.android_watch.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nilufer on 9.07.2018.
 *Performs data operations related to WebService
 */

@Module
public class APIClient {

    private static Retrofit retrofit = null;
    private static String BASE_URL= "http://janusdev.denizbank.com/api/";

   // private static String BASE_URL= "http://ebelediye.gebze.bel.tr/NicoExporter/exp/eczaneServis/";

    @Provides
    public static Retrofit getRetrofitInstance(){
        if (retrofit == null) {
            return  getClient();
        } else {
            return retrofit;
        }
    }

    @Singleton
    private static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;

    }
}
