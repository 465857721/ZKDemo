package com.kingsoft.zkdemo.coordinatorlayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.kingsoft.zkdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BehaviorALLActivity extends AppCompatActivity {

    @BindView(R.id.btn_behavior_follow)
    Button btnBehavior;
    @BindView(R.id.btn_behavior_head_test)
    Button btnBehaviorHeadTest;
    @BindView(R.id.btn_behavior_uc)
    Button btnBehaviorUc;
    @BindView(R.id.activity_behavior_all)
    LinearLayout activityBehaviorAll;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior_all);
        ButterKnife.bind(this);
        mContext = this;
    }

    @OnClick({R.id.btn_behavior_follow, R.id.btn_behavior_head_test, R.id.btn_behavior_uc})
    public void onClick(View view) {
        Intent mIntent = new Intent();
        switch (view.getId()) {
            case R.id.btn_behavior_follow:
                mIntent.setClass(mContext, BehaviorFollowActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_behavior_head_test:
                mIntent.setClass(mContext, HeaderScrollingBehaviorActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_behavior_uc:
                //http://www.jianshu.com/p/f7989a2a3ec2
                break;
        }
    }
}
