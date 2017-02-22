package com.lemoni.view.myinterface;

/**
 * Created by dellit on 2017/2/20.
 */

public interface OnDemoListener<T> extends OnBaseListener {
    void OnSuccess(T t);
}
