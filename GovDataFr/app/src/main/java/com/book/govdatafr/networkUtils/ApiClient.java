package com.book.govdatafr.networkUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    private static ApiClient instance =null;

    private ApiClient() {
    }

    public static ApiClient getInstance(){
        if(instance==null){
            instance= new ApiClient();
        }
        return instance;
    }

    public Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).
                connectTimeout(30000, TimeUnit.MILLISECONDS).
                readTimeout(30000, TimeUnit.MILLISECONDS).build();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://geo.api.gouv.fr")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();


        return retrofit;
    }

}
