package com.lemoni.model.api;

import android.util.Log;

import com.lemoni.model.bean.HttpResult;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dellit on 2017/2/21.
 * 传入一个被观察者和观察者进行订阅
 */

public class RxHelper {
    public static <T>void toSubscriber(Observable<HttpResult<T>> observable, CustomObeserver<T> observer){
        Log.d("RxHelper", "aaadddd");
        observable
                .subscribeOn(Schedulers.io())
                /**
                 * 起到一个过滤的作用
                 * 根据error_code的值确定是否返回bean（Data）
                 */
                .map(new Function<HttpResult<T>, T>() {
                    @Override
                    public T apply(HttpResult<T> tHttpResult) throws Exception {
                        if(tHttpResult.error_code!=0){
                        }
                        return tHttpResult.result;
                    }
                })
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(observer);
    }
}
