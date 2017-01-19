package com.kingsoft.zkdemo.animation.spring;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kingsoft.zkdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SpringActivity extends AppCompatActivity {

    @BindView(R.id.pen)
    SpringView pen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.pen})
    public void onClick() {
        pen.star();
    }

}
