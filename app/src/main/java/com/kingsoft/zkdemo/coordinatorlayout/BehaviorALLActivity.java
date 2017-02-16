package com.kingsoft.zkdemo.coordinatorlayout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kingsoft.zkdemo.R;
import com.kingsoft.zkdemo.main.DemoBean;
import com.kingsoft.zkdemo.main.MainAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BehaviorALLActivity extends AppCompatActivity {
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
                new DemoBean("Behavior学习", BehaviorFollowActivity.class),
                new DemoBean("简单实现头部滚动视觉差", SampleBehaviorActivity.class),
                new DemoBean("header_scrolling_behavior自定义", HeaderScrollingBehaviorActivity.class),


        };
        MainAdapter adapter = new MainAdapter(arr, this);
        mainRcl.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mainRcl.setAdapter(adapter);
        DividerItemDecoration di = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        di.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider_bg));
        mainRcl.addItemDecoration(di);
        mainRcl.setItemAnimator(new DefaultItemAnimator());
    }

//    @OnClick({R.id.btn_behavior_follow, R.id.btn_behavior_head_test, R.id.btn_behavior_uc})
//    public void onClick(View view) {
//        Intent mIntent = new Intent();
//        switch (view.getId()) {
//            case R.id.btn_behavior_follow:
//                mIntent.setClass(mContext, BehaviorFollowActivity.class);
//                startActivity(mIntent);
//                break;
//            case R.id.btn_behavior_head_test:
//                mIntent.setClass(mContext, HeaderScrollingBehaviorActivity.class);
//                startActivity(mIntent);
//                break;
//            case R.id.btn_behavior_uc:
//                //http://www.jianshu.com/p/f7989a2a3ec2
//                break;
//        }
//    }
}
