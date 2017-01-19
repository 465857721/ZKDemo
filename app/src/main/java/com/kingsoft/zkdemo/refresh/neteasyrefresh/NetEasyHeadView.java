package com.kingsoft.zkdemo.refresh.neteasyrefresh;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.kingsoft.zkdemo.R;

/**
 * Author:    Diamond_Lin
 * Version    V1.0
 * Date:      16/10/14 下午4:19
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 16/10/14      Diamond_Lin            1.0                    1.0
 * Why & What is modified:
 */
public class NetEasyHeadView extends RelativeLayout implements IRefreshHeader {
    //    public Bezier mBezierLine;
    boolean isLeft;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            addShop();
            handler.sendEmptyMessageDelayed(0, 250);
        }
    };
    private Context mContext;

    private int mHeight;
    private int mWidth;
    private LayoutParams lp;
    private View rongYi;

    public NetEasyHeadView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public NetEasyHeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }


    public NetEasyHeadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    private void init() {


        View view = View.inflate(getContext(), R.layout.widget_rongyi_neteasy, this);
        rongYi = view.findViewById(R.id.iv_rongyi);
        //获取图的宽高 用于后面的计算
        //注意 我这里3张图片的大小都是一样的,所以我只取了一个

        //底部 并且 水平居中
        lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(CENTER_HORIZONTAL, TRUE);//这里的TRUE 要注意 不是true
        lp.addRule(ALIGN_PARENT_BOTTOM, TRUE);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        lp.setMargins(0, 0, 0, rongYi.getHeight() + Utils.dp2px(getContext(), 20) + 8);
    }


    @Override
    public void reset() {
//        mBezierLine.refreshFinish();
    }

    @Override
    public void pull() {
    }

    @Override
    public void refreshing() {
//        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 1.0f, 0.95f, 1.0f,
//                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        scaleAnimation.setDuration(800);
//        scaleAnimation.setRepeatCount(100);
//        rongYi.startAnimation(scaleAnimation);
        star();
    }

    @Override
    public void onPositionChange(float currentPos, float lastPos, float refreshPos, boolean isTouch, RefreshLayout.State state) {
//        mBezierLine.setControlY(currentPos);

        Log.d("zk ", "currentPos=" + currentPos);
        Log.d("zk ", "lastPos=" + lastPos);
        Log.d("zk ", "refreshPos=" + refreshPos);
        Log.d("zk ", "isTouch=" + isTouch);
        Log.d("zk ", "state=" + state);


//        if (currentPos > mHeight) {
//            int translationY = (int) (currentPos - mHeight);
//
//            int dp20 = Utils.dp2px(getContext(), 20);
//            if (translationY > dp20) {
//                translationY = dp20;
//            }
////            mIvTrans.setTranslationY(dp20 - translationY);
//        } else {
////            mIvTrans.setTranslationY(Utils.dp2px(getContext(), 20));
//        }
    }

    @Override
    public void complete() {
        stop();
//        rongYi.getAnimation().cancel();
    }

    public void star() {
//        handler.sendEmptyMessage(0);
    }

    public void stop() {
//        handler.removeCallbacksAndMessages(null);
    }

}
