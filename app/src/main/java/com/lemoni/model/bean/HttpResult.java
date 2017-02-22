package com.lemoni.model.bean;

/**
 * Created by dellit on 2017/2/21.
 */

public class HttpResult<T> {
    public int error_code;
    public String reason;
    public T result;
}
