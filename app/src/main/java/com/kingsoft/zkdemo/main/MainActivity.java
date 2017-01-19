package com.kingsoft.zkdemo.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.kingsoft.zkdemo.R;
import com.kingsoft.zkdemo.coordinatorlayout.BehaviorALLActivity;
import com.kingsoft.zkdemo.download.test.DownMainActivity;
import com.kingsoft.zkdemo.greendao.GreenDaoActivity;
import com.kingsoft.zkdemo.nightmode.NightALLActivity;
import com.kingsoft.zkdemo.objectanimator.ObjectAnimatorActivity;
import com.kingsoft.zkdemo.okhttp.OKHttpActivity;
import com.kingsoft.zkdemo.refresh.ReFreshALLActivity;
import com.kingsoft.zkdemo.refresh.demo.RefreshActivity;
import com.kingsoft.zkdemo.viewpage.ViewPagerAllActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_behavior)
    Button btnBehavior;
    @BindView(R.id.btn_ocr)
    Button btnOcr;
    @BindView(R.id.btn_translation)
    Button btnTranslation;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.btn_viewpage)
    Button btnViewpage;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
    }

    @OnClick({R.id.btn_refresh,R.id.btn_greendao, R.id.btn_okhttp, R.id.btn_down, R.id.btn_behavior, R.id.btn_ocr, R.id.btn_translation, R.id.btn_viewpage, R.id.btn_nightmode})
    public void onClick(View view) {
        Intent mIntent = new Intent();
        switch (view.getId()) {
            case R.id.btn_behavior:
                mIntent.setClass(mContext, BehaviorALLActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_translation:
                mIntent.setClass(mContext, ObjectAnimatorActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_viewpage:
                mIntent.setClass(mContext, ViewPagerAllActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_nightmode:
                mIntent.setClass(mContext, NightALLActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_down:
                mIntent.setClass(mContext, DownMainActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_okhttp:
                mIntent.setClass(mContext, OKHttpActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_greendao:
                mIntent.setClass(mContext, GreenDaoActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_refresh:
                mIntent.setClass(mContext, ReFreshALLActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_ocr:
                break;
        }
    }

}
