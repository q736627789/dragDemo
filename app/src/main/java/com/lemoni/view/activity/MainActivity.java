package com.lemoni.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dellit.lemonlivei.R;
import com.lemoni.model.api.CustomObeserver;
import com.lemoni.model.api.RetrofitUtil;
import com.lemoni.model.api.RxHelper;
import com.lemoni.model.bean.Data;
import com.lemoni.model.bean.HttpResult;
import com.lemoni.presenter.APIServerPresenter;

import java.util.List;

import io.reactivex.Observable;

public class MainActivity extends BaseActivity {


    /**
     * 初始化contentView
     */
    @Override
    protected void initContentView() {
        setContentView(R.layout.activity_main);
    }

    /**
     *  初始化控件UI
     */
    @Override
    protected void initUI() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("TAG","aaaa");

        Observable<HttpResult<List<Data>>> observable =
                RetrofitUtil.getInstance().getApiDataServer().getBean("","a86fd542871ea3999ae1e02479664148");
        RxHelper.toSubscriber(observable, new CustomObeserver<List<Data>>(this) {

            @Override
            public void dialogListener() {

            }

            @Override
            public void OnSuccess(List<Data> datas) {
                Log.d("MainActivity", datas.get(0).getContent());
            }
        });


    }
}
