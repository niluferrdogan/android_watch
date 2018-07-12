package com.example.bsobe.android_watch.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Nilufer on 9.07.2018.
 */

public interface APIInterface {
    @GET("findAllNobetciEczane")
    Call<List<CurrencyResources>> doGetListResources();


/*    @POST("/oauth/token")
    Call<AccessToken> getNewAccessToken(
            @Field("token") String token);
*/
}
