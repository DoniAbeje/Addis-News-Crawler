package com.addisnews.crawler.network;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIConnector{
   private static RetrofitConnector instance;
   public static RetrofitConnector getConnector(){
       if (instance == null){
           Retrofit retrofit = new Retrofit.Builder()
                   .baseUrl("http://localhost:8000/api/")
                   .addConverterFactory(GsonConverterFactory.create())
                   .client(new OkHttpClient())
                   .build();

           instance = retrofit.create(RetrofitConnector.class);
       }

       return instance;
   }
}
