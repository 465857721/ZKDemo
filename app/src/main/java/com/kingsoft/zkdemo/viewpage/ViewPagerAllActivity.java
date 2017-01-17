package com.kingsoft.zkdemo.viewpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kingsoft.zkdemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewPagerAllActivity extends AppCompatActivity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_all);
        ButterKnife.bind(this);
        mContext = this;
    }

    @OnClick({R.id.btn_viewpageneteasy, R.id.btn_viewpageargb})
    public void onClick(View view) {
        Intent mIntent = new Intent();
        switch (view.getId()) {
            case R.id.btn_viewpageargb:
                mIntent.setClass(mContext, ViewPagerGradientActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_viewpageneteasy:
                mIntent.setClass(mContext, ViewPagerNetEasyActivity.class);
                startActivity(mIntent);
                break;
        }
    }
}
