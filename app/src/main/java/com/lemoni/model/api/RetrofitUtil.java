package com.lemoni.model.api;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dellit on 2017/2/20.
 */

public class RetrofitUtil {
    private  Retrofit retrofit;
    //加入volatile的特性：禁止指令重排序优化
    private volatile static RetrofitUtil observableUtil;
    private static final int TIME_OUT = 5;
    private static ApiDataServer apiDataServer;

    private RetrofitUtil(){
        //手动设置一个OKHttpClient并设置超时时间
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient().newBuilder();
        okHttpBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        //初始化Retrofit
        apiDataServer = new Retrofit.Builder()
                .client(okHttpBuilder.build())
                .baseUrl(HttpURL.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiDataServer.class);
    }
    public static RetrofitUtil getInstance(){
        if(observableUtil ==null){
            synchronized (RetrofitUtil.class){
                if (observableUtil == null){
                    observableUtil = new RetrofitUtil();
                }
            }
        }
        return observableUtil;
    }

    public ApiDataServer getApiDataServer(){
        return apiDataServer;
    }
}
