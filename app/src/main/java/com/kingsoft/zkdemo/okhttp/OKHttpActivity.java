package com.kingsoft.zkdemo.okhttp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kingsoft.zkdemo.R;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * http://www.open-open.com/lib/view/open1483965821658.html
 */
public class OKHttpActivity extends AppCompatActivity {
    public static final String TAG = "zk_okhttp";
    @BindView(R.id.tv_response)
    TextView tvResponse;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        ButterKnife.bind(this);
        mHandler = new Handler();
    }

    @OnClick({R.id.tv_response, R.id.btn_sample})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sample:
                getStringSample_byokhttp();
                break;
        }
    }

    private void postJson() throws IOException {
        String url = "http://write.blog.csdn.net/postlist/0/0/enabled/1";
        String json = "haha";

        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        client.newCall(request).enqueue(new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Log.d(TAG, response.body().string());
            }
        });


    }

    /**
     * 将文件上传到服务器上：
     */
    private void postFile() {
        MediaType MEDIA_TYPE_MARKDOWN
                = MediaType.parse("text/x-markdown; charset=utf-8");
        OkHttpClient mOkHttpClient = new OkHttpClient();
        File file = new File("/sdcard/demo.txt");
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
                .build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG, response.body().string());
            }
        });

    }
    /**
     *POST提交键值对很多时候我们会需要通过POST方式把键值对数据传送到服务器。 OkHttp提供了很方便的方式来做这件事情。
     * @param url
     * @throws IOException
     */
    private void post(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("name", "liming")
                .add("school", "beida")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.i(TAG, str);

            }

        });
    }
    private void getStringSample_byokhttp() {
        String url = "http://news-at.zhihu.com/api/4/start-image/1080*1776";
        OkHttpClient mHttpClient = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();

        mHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String json = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvResponse.setText(json);
                    }
                });
                Log.d("okHttp", json);
            }
        });

//        OkHttpUtils.getInstance().get(url, new BaseCallback<BaseBean>() {
//            @Override
//            public void onBeforeRequest(Request request) {
//
//            }
//
//            @Override
//            public void onFailure(Request request, Exception e) {
//
//            }
//
//            @Override
//            public void onResponse(Response response) {
//
//            }
//
//            @Override
//            public void onSuccess(Response response, BaseBean o) {
//
//            }
//
//            @Override
//            public void onError(Response response, int code, Exception e) {
//
//            }
//
//            @Override
//            public void onTokenError(Response response, int code) {
//
//            }
//        });


        //        okhttp3.Response response = null;
//        try {
//            response = mHttpClient.newCall(request).execute();
//            final String json = response.body().string();
//            new Handler().post(new Runnable() {
//                @Override
//                public void run() {
//                    tvResponse.setText(json);
//                }
//            });
//
//        } catch (IOException e) {
//            e.printStackTrace();
//    }

    }
}
