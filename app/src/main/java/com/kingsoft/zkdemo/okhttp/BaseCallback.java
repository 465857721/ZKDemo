package com.kingsoft.zkdemo.okhttp;

import com.google.gson.internal.$Gson$Types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by 周康 on 2017/1/13.
 */

public abstract class BaseCallback<T> {
    public Type mType;

    public BaseCallback() {
        mType = getSuperclassTypeParameter(getClass());
    }

    static Type getSuperclassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
    }

    public abstract void onBeforeRequest(Request request);

    public abstract void onFailure(Request request, Exception e);

    public abstract void onResponse(Response response);

    /**
     * 状态码大于200，小于300 时调用此方法
     *
     * @param response
     * @param t
     * @throws
     */
    public abstract void onSuccess(Response response, T t);

    /**
     * 状态码400，404，403，500等时调用此方法
     *
     * @param response
     * @param code
     * @param e
     */
    public abstract void onError(Response response, int code, Exception e);

    /**
     * Token 验证失败。状态码401,402,403 等时调用此方法
     *
     * @param response
     * @param code
     */
    public abstract void onTokenError(Response response, int code);
}
