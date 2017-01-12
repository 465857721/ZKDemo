package com.kingsoft.zkdemo.nightmode;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kingsoft.zkdemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * http://blog.csdn.net/zhangphil/article/details/52860878
 * http://www.jb51.net/article/79720.htm
 */
public class NightUIManagerActivity extends AppCompatActivity {
    private UiModeManager mUiModeManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night__uimanager);
        ButterKnife.bind(this);
        mUiModeManager = (UiModeManager) getSystemService(Context.UI_MODE_SERVICE);
    }

    @OnClick({R.id.btn_day, R.id.btn_night})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_day:
                mUiModeManager.setNightMode(UiModeManager.MODE_NIGHT_NO);
                break;
            case R.id.btn_night:
                mUiModeManager.setNightMode(UiModeManager.MODE_NIGHT_YES);
                break;
        }
    }
}
