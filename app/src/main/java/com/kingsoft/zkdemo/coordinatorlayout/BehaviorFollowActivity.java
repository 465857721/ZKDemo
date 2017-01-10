package com.kingsoft.zkdemo.coordinatorlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.kingsoft.zkdemo.R;
//http://www.open-open.com/lib/view/open1480387021766.html
public class BehaviorFollowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior);
        findViewById(R.id.btn).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    v.setX(event.getRawX()-v.getWidth()/2);
                    v.setY(event.getRawY()-v.getHeight()/2);
                }
                return true;
            }
        });
    }
}
