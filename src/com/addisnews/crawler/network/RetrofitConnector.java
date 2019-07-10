package com.addisnews.crawler.network;

import com.addisnews.crawler.domain.News;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface RetrofitConnector {

    @POST("news")
    public Call<Void> insertNews(@Body News ... news);

    @GET("news/{source}/last")
    public Call<News> getLastNewsBySource(@Path("source") String source);

    @GET("news/{source}/{date}")
    public Call<List<News>> getNewsByDateAndSource(@Path("source") String source, @Path("date") String date);



}
