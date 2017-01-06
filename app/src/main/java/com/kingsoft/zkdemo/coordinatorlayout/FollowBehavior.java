package com.kingsoft.zkdemo.coordinatorlayout;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * Created by 周康 on 2016/12/16.
 */

public class FollowBehavior extends CoordinatorLayout.Behavior {

    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
//        return super.layoutDependsOn(parent, child, dependency);
        return dependency instanceof  Button;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
//        return super.onDependentViewChanged(parent, child, dependency);
        child.setX(dependency.getX() + 550);
        child.setY(dependency.getY() + 550);
//        child.setScaleX();
        return true;
    }
}
