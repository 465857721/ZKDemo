package com.kingsoft.zkdemo.animation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kingsoft.zkdemo.R;
import com.kingsoft.zkdemo.animation.objectanimator.ObjectAnimatorActivity;
import com.kingsoft.zkdemo.animation.other.WaveloadingActivity;
import com.kingsoft.zkdemo.animation.spring.SpringActivity;
import com.kingsoft.zkdemo.coordinatorlayout.BehaviorALLActivity;
import com.kingsoft.zkdemo.coordinatorlayout.BehaviorFollowActivity;
import com.kingsoft.zkdemo.coordinatorlayout.HeaderScrollingBehaviorActivity;
import com.kingsoft.zkdemo.coordinatorlayout.SampleBehaviorActivity;
import com.kingsoft.zkdemo.main.DemoBean;
import com.kingsoft.zkdemo.main.MainAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationALLActivity extends AppCompatActivity {
    private Context mContext;
    @BindView(R.id.main_rcl)
    RecyclerView mainRcl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        DemoBean[] arr = {
                new DemoBean("ObjectAnimator", ObjectAnimatorActivity.class),
                new DemoBean("喷泉特效", SpringActivity.class),
                new DemoBean("波浪加载 灰色特效", WaveloadingActivity.class)

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
