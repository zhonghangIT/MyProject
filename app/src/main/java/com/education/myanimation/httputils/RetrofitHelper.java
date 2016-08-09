package com.education.myanimation.httputils;

import com.education.myanimation.config.UrlConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    public Retrofit retrofit;
    public Gson gson;
    private static RetrofitHelper instance;

    private RetrofitHelper() {
    }

    public static synchronized RetrofitHelper getInstance() {
        if (instance == null) {
            instance = new RetrofitHelper();
        }
        return instance;
    }


    public <T> T createRetrofitService(Class<T> service) {
        if (retrofit == null) {
            createGson();
            initRetrofit();
        }
        return retrofit.create(service);
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlConfig.Path.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    private void createGson() {
        gson = new GsonBuilder()
                .serializeNulls()
                .create();
    }

}