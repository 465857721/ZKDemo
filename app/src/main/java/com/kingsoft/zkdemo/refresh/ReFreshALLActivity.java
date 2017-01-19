package com.kingsoft.zkdemo.refresh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kingsoft.zkdemo.R;
import com.kingsoft.zkdemo.refresh.demo.RefreshActivity;
import com.kingsoft.zkdemo.refresh.neteasyrefresh.NetEasyRefreshActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReFreshALLActivity extends AppCompatActivity {

    @BindView(R.id.btn_refresh)
    Button btnRefresh;
    @BindView(R.id.btn_netrefresh)
    Button btnNetrefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_fresh_all);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_refresh, R.id.btn_netrefresh})
    public void onClick(View view) {
        Intent mIntent = new Intent();
        switch (view.getId()) {
            case R.id.btn_refresh:
                mIntent.setClass(this, RefreshActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_netrefresh:
                mIntent.setClass(this, NetEasyRefreshActivity.class);
                startActivity(mIntent);
                break;
        }
    }
}
