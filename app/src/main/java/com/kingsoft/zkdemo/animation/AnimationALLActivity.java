package com.kingsoft.zkdemo.animation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kingsoft.zkdemo.R;
import com.kingsoft.zkdemo.animation.objectanimator.ObjectAnimatorActivity;
import com.kingsoft.zkdemo.animation.spring.SpringActivity;
import com.kingsoft.zkdemo.coordinatorlayout.BehaviorALLActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationALLActivity extends AppCompatActivity {
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_all);
        ButterKnife.bind(this);
        mContext = this;
    }

    @OnClick({R.id.btn_object, R.id.btn_penquan})
    public void onClick(View view) {
        Intent mIntent = new Intent();

        switch (view.getId()) {
            case R.id.btn_object:
                mIntent.setClass(mContext, ObjectAnimatorActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_penquan:
                mIntent.setClass(mContext, SpringActivity.class);
                startActivity(mIntent);
                break;
        }
    }
}
