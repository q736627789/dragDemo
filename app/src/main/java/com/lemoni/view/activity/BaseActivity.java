package com.lemoni.view.activity;

import android.app.Activity;
import android.os.Bundle;

import com.lemoni.view.myview.WaitDiaLog;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by dellit on 2017/2/20.
 */

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView();
        initUI();
    }

    //用来初布局
    protected abstract void initContentView();
    //用来初始化UI
    protected  abstract void  initUI();

}
