package com.kingsoft.zkdemo.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kingsoft.zkdemo.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
//http://blog.csdn.net/jungle_pig/article/details/54692643
public class RXJAVAActivity extends AppCompatActivity {
    private final String TAG = "zk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        //创建一个上游 Observable：
//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                emitter.onNext(1);
//                emitter.onNext(2);
//                emitter.onNext(3);
//                emitter.onComplete();
//            }
//        });
//        //创建一个下游 Observer
//        Observer<Integer> observer = new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "subscribe");
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                Log.d(TAG, "" + value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "error");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "complete");
//            }
//        };
//        //建立连接
//        observable.subscribe(observer);



        //把这段代码连起来写就成了RxJava引以为傲的链式操作：
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {

                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "subscribe");
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "" + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "error");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "complete");
            }
        });
    }

}
