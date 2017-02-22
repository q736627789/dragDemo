package com.lemoni.model.api;

import com.lemoni.model.bean.Data;
import com.lemoni.model.bean.HttpResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by dellit on 2017/2/20.
 */

public interface ApiDataServer{
    @FormUrlEncoded
    @POST("joke/randJoke.php")
    Observable<HttpResult<List<Data>>> getBean(@Field("type") String type ,@Field("key") String key);
}
