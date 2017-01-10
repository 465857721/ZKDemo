package com.kingsoft.zkdemo.coordinatorlayout;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.kingsoft.zkdemo.R;

import java.lang.ref.WeakReference;


public class TestGoLeftBehavior extends CoordinatorLayout.Behavior<View> {

    private WeakReference<View> dependentView;
    private ArgbEvaluator argbEvaluator;

    public TestGoLeftBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);

        argbEvaluator = new ArgbEvaluator();
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        if (dependency != null && dependency.getId() == R.id.scrolling_header) {
            dependentView = new WeakReference<>(dependency);
            return true;
        }
        return false;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        Resources resources = getDependentView().getResources();
        final float progress = 1.f -
                Math.abs(dependency.getTranslationY() / (dependency.getHeight() - resources.getDimension(R.dimen.collapsed_header_height)));
        //R.dimen.collapsed_header_height   是 输入框的高度 40 加上  上下的5margin·
        //dependency.getTranslationY() recycl  view距离顶部的距离
        // (dependency.getHeight() - resources.getDimension(R.dimen.collapsed_header_height)
        // 减去 edt的高度  就是 总共可以向上移动的距离，然后滑动的距离除以 总共可以滑动的距离得到比例

        // Translation
        final float collapsedOffset = resources.getDimension(R.dimen.collapsed_float_offset_y);

        final float initOffset = resources.getDimension(R.dimen.init_float_offset_y);
//        final float translateY = collapsedOffset + (initOffset - collapsedOffset) * progress;
//        child.setTranslationY(translateY);
        final float FX = parent.getWidth() / 2 - parent.getWidth() / 2 * (1 - progress);
        final float FY = initOffset - initOffset * (1.f - progress);
        child.setX(FX);
        child.setY(FY);
        // Background
//        child.setBackgroundColor((int) argbEvaluator.evaluate(
//                progress,
//                resources.getColor(R.color.colorCollapsedFloatBackground),
//                resources.getColor(R.color.colorInitFloatBackground)));

        // Margins
//        final float collapsedMargin = resources.getDimension(R.dimen.collapsed_float_margin);//结束状态的margin
//        final float initMargin = resources.getDimension(R.dimen.init_float_margin);// 初始状态的左右margin
////        final float initMargin = 50;
//        final int margin = (int) (collapsedMargin + (initMargin - collapsedMargin) * progress);
//        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
//        lp.setMargins(margin, 0, margin, 0);
//        child.setLayoutParams(lp);

        return true;
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    private View getDependentView() {
        return dependentView.get();
    }

}
