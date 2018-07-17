package com.example.bsobe.android_watch.retrofit;

import com.example.bsobe.android_watch.access_token.AccesTokenRequest;
import com.example.bsobe.android_watch.access_token.AccessTokenResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Nilufer on 9.07.2018.
 */

public interface APIInterface {
    @GET("calculations/cross-currencies")
  //  @Header()
    Call<CurrencyResources> doGetListResources(@Query("type") String type, @Query("currency") String currency,
                                                     @Header("X-Token") String token);


    @POST("auth/token")
    Call<AccessTokenResponse> getNewAccessToken(@Body AccesTokenRequest request);

}
