package com.kingsoft.zkdemo.rx.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kingsoft.zkdemo.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
//
//        上游可以发送无限个onNext, 下游也可以接收无限个onNext.
//                当上游发送了一个onComplete后, 上游onComplete之后的事件将会继续发送, 而下游收到onComplete事件之后将不再继续接收事件.
//                当上游发送了一个onError后, 上游onError之后的事件将继续发送, 而下游收到onError事件之后将不再继续接收事件.
//                上游可以不发送onComplete或onError.
//                最为关键的是onComplete和onError必须唯一并且互斥, 即不能发多个onComplete, 也不能发多个onError, 也不能先发一个onComplete, 然后再发一个onError, 反之亦然

        //把这段代码连起来写就成了RxJava引以为傲的链式操作：
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                // 可以执行耗时操作  可以设置在 io进程
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
//    在RxJava中, 已经内置了很多线程选项供我们选择, 例如有
//
//    Schedulers.io() 代表io操作的线程, 通常用于网络,读写文件等io密集型的操作
//    Schedulers.computation() 代表CPU计算密集型的操作, 例如需要大量计算的操作
//    Schedulers.newThread() 代表一个常规的新线程
//    AndroidSchedulers.mainThread() 代表Android的主线程

}
