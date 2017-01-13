package com.kingsoft.zkdemo.okhttp;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 周康 on 2017/1/13.
 */

public class OkHttpUtils {
    private static OkHttpUtils mInstance;

    static {
        mInstance = new OkHttpUtils();
    }

    private OkHttpClient mHttpClient;
    private Gson mGson;

    private OkHttpUtils() {
        mHttpClient = new OkHttpClient();
        OkHttpClient.Builder builder = mHttpClient.newBuilder();
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);
        mGson = new Gson();

    }

    public static OkHttpUtils getInstance() {
        return mInstance;
    }

    public void get(String url, BaseCallback callback) {
        Request request = buildRequest(url, HttpMethodType.GET, null);
        doRequest(request, callback);
    }

    public void post(String url, Map<String, String> params, BaseCallback callback) {
        Request request = buildRequest(url, HttpMethodType.POST, params);
        doRequest(request, callback);
    }

    private void callbackSuccess(final BaseCallback callback, final Response response, final Object obj) {

//        mHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                callback.onSuccess(response, obj);
//            }
//        });
    }

    private void callbackError(final BaseCallback callback, final Response response, final Exception e) {

//        mHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                callback.onError(response, response.code(), e);
//            }
//        });
    }

    public void doRequest(final Request request, final BaseCallback baseCallback) {
        baseCallback.onBeforeRequest(request);
        mHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                baseCallback.onFailure(request, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String resultStr = response.body().string();
                    if (baseCallback.mType == String.class) {
                        callbackSuccess(baseCallback, response, resultStr);
                    } else {
                        try {
                            Object obj = mGson.fromJson(resultStr, baseCallback.mType);
                            callbackSuccess(baseCallback, response, obj);
                        } catch (com.google.gson.JsonParseException e) { // Json解析的错误
                            callbackError(baseCallback, response, e);
                        }
                    }
                } else {
                    callbackError(baseCallback, response, null);
                }
            }
        });
    }


    private Request buildRequest(String url, HttpMethodType methodType, Map<String, String> params) {
        Request.Builder builder = new Request.Builder()
                .url(url);
        if (methodType == HttpMethodType.POST) {
            RequestBody body = builderFormData(params);
            builder.post(body);
        } else if (methodType == HttpMethodType.GET) {
            builder.get();
        }
        return builder.build();

    }

    private RequestBody builderFormData(Map<String, String> params) {
        FormBody.Builder builder = new FormBody.Builder();

        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        return builder.build();
    }

    enum HttpMethodType {
        GET,
        POST,
    }
}