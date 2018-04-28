package com.dxt2.mvpretrorxjademoo.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/4/28 0028.
 */

/*
* 封装Retrofit请求过程
* */
public class ApiFengRetro {
    public static String baseUr = "http://interfaces.ziroom.com/";
    public static ApiService apiService;

    public static ApiService getApiService() {
        if (apiService == null) {
            synchronized (ApiFengRetro.class) {
                if (apiService == null) {
                    new ApiFengRetro();
                }
            }
        }
        return apiService;
    }
    private ApiFengRetro(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUr)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);

    }

}
