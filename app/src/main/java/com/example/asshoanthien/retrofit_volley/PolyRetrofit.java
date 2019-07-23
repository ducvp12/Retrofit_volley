package com.example.asshoanthien.retrofit_volley;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PolyRetrofit {
    public static Retrofit retrofit;
    public static Retrofit getinsteance(){
        if (retrofit== null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://asian.dotplays.com/").addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
