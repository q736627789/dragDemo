package com.lemoni.presenter;

import com.lemoni.view.myinterface.OnBaseListener;

/**
 * Created by dellit on 2017/2/20.
 * presenter基类
 */

public class BasePresenter <T extends OnBaseListener>  {

    private T subView;
//
//    public void setSubView(T subView){
//        this.subView = subView;
//    }
//    public T getSubView() {
//        return subView;
//    }

}

