package com.kingsoft.zkdemo.animation.objectanimator;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.kingsoft.zkdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
//http://www.open-open.com/lib/view/open1483583703768.html
public class ObjectAnimatorActivity extends AppCompatActivity {

    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.btn_translationy)
    Button btnTranslationy;
    @BindView(R.id.activity_object_animator)
    RelativeLayout activityObjectAnimator;
    @BindView(R.id.ll_color)
    View llColor;
    @BindView(R.id.btn_changecolor)
    Button btnChangecolor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.iv_icon, R.id.btn_translationy, R.id.btn_changecolor, R.id.btn_set})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_icon:
                Toast.makeText(this, "我还能点击", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_translationy:
                translateViewByObjectAnimator(ivIcon);
                break;
            case R.id.btn_set:
                startAnimationSet(ivIcon);
                break;
            case R.id.btn_changecolor:
                changeViewBackGroundColor(llColor);
                break;
        }
    }

    /**
     * 将 View 沿着垂直方向移动 View 高度的距离
     *
     * @param targetView 被移动的 View
     */
    private void translateViewByObjectAnimator(View targetView) {
        //TranslationY 目标 View 要改变的属性
        //ivShow.getHeight() 要移动的距离
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(targetView, "TranslationX", 200);
        objectAnimator.start();
    }

    /**
     * 改变 View 对象的背景色由红色变为蓝色
     *
     * @param targetView
     */
    private void changeViewBackGroundColor(View targetView) {
        ValueAnimator valueAnimator = ObjectAnimator.ofInt(targetView, "backgroundColor", Color.WHITE, Color.BLACK);
//        ValueAnimator valueAnimator = ObjectAnimator.ofInt(targetView, "backgroundColor", Color.RED, Color.BLUE);
        valueAnimator.setDuration(10000);
        //设置估值器，该处插入颜色估值器
        valueAnimator.setEvaluator(new ArgbEvaluator());
        //无限循环
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        //翻转模式
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();
    }

    /**
     * 启动一个动画集合
     *
     * @param targetView
     */
    private void startAnimationSet(View targetView) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(targetView, "rotationX", 0, 360),
                //旋转
                ObjectAnimator.ofFloat(targetView, "rotationY", 0, 360),
                ObjectAnimator.ofFloat(targetView, "rotation", 0, -90),
                //平移
                ObjectAnimator.ofFloat(targetView, "translationX", 0, 90),
                ObjectAnimator.ofFloat(targetView, "translationY", 0, 90),
                //缩放
                ObjectAnimator.ofFloat(targetView, "scaleX", 1, 1.5f),
                ObjectAnimator.ofFloat(targetView, "scaleY", 1, 1.5f),
                //透明度
                ObjectAnimator.ofFloat(targetView, "alpha", 1, 0.25f, 1));
        animatorSet.setDuration(3000).start();
    }
}
