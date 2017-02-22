package com.lemoni.model.api;


import android.content.Context;
import android.util.Log;

import com.lemoni.view.myview.WaitDiaLog;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by dellit on 2017/2/21.
 */

public abstract class CustomObeserver<T> implements Observer<T>,WaitDiaLog.DialogListener {

    private final WaitDiaLog diaLog;

    public CustomObeserver(Context context){
        diaLog = WaitDiaLog.getInstance(context, this);
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.d("CustomObeserver", "onSubscribe");
        diaLog.DialogShow();
    }

    @Override
    public void onNext(T value) {
        Log.d("CustomObeserver", "onNext");
        OnSuccess(value);
    }

    @Override
    public void onError(Throwable e) {
        Log.d("CustomObeserver", e.toString());
    }

    @Override
    public void onComplete() {
//        diaLog.DialogDissmiss();
        Log.d("CustomObeserver","onComplete");
    }


    public abstract void OnSuccess(T t);
}
