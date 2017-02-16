package com.kingsoft.zkdemo.rx;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kingsoft.zkdemo.R;
import com.kingsoft.zkdemo.animation.AnimationALLActivity;
import com.kingsoft.zkdemo.coordinatorlayout.BehaviorALLActivity;
import com.kingsoft.zkdemo.download.test.DownMainActivity;
import com.kingsoft.zkdemo.greendao.GreenDaoActivity;
import com.kingsoft.zkdemo.main.DemoBean;
import com.kingsoft.zkdemo.main.MainAdapter;
import com.kingsoft.zkdemo.nightmode.NightALLActivity;
import com.kingsoft.zkdemo.okhttp.OKHttpActivity;
import com.kingsoft.zkdemo.refresh.ReFreshALLActivity;
import com.kingsoft.zkdemo.rx.rxjava.RXJAVAActivity;
import com.kingsoft.zkdemo.viewpage.ViewPagerAllActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RxSeriesActivity extends AppCompatActivity {
    @BindView(R.id.main_rcl)
    RecyclerView mainRcl;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        DemoBean[] arr = {
                new DemoBean("RxJava", RXJAVAActivity.class),
        };
        MainAdapter adapter = new MainAdapter(arr, this);
        mainRcl.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mainRcl.setAdapter(adapter);
        DividerItemDecoration di = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        di.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider_bg));
        mainRcl.addItemDecoration(di);
        mainRcl.setItemAnimator(new DefaultItemAnimator());

    }


}
