package com.kingsoft.zkdemo.nightmode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kingsoft.zkdemo.R;
import com.kingsoft.zkdemo.coordinatorlayout.BehaviorALLActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NightALLActivity extends AppCompatActivity {
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night_all);
        ButterKnife.bind(this);
        mContext = this;
    }

    @OnClick({R.id.btn_uimanager, R.id.btn_restar})
    public void onClick(View view) {
        Intent mIntent = new Intent();
        switch (view.getId()) {
            case R.id.btn_uimanager:
                mIntent.setClass(mContext, NightUIManagerActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_restar:
                break;
        }
    }
}
