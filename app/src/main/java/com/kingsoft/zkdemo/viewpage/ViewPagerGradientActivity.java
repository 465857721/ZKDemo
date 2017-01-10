package com.kingsoft.zkdemo.viewpage;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kingsoft.zkdemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ViewPagerGradientActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    int endColor;
    private View view1, view2, view3;
    private List<View> viewList;//view数组
    //这是我三个页面分别用到的背景色
    private int colors[] = {Color.RED, Color.BLUE, Color.GREEN};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_gradient);
        ButterKnife.bind(this);

        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.view1, null);
        view2 = inflater.inflate(R.layout.view2, null);
        view3 = inflater.inflate(R.layout.view3, null);

        viewList = new ArrayList<>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
//        main_ll = viewpager;
        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));


                return viewList.get(position);
            }
        };


        viewpager.setAdapter(pagerAdapter);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("zk position=", "" + position);
                Log.d("zk positionOffset=", "" + positionOffset);
                Log.d("zk ", "positionOffsetPixels=" + positionOffsetPixels);

                //得到 颜色 估值器
                ArgbEvaluator evaluator = new ArgbEvaluator();
                //给布局设置初始颜色
                viewpager.setBackgroundColor(colors[position]);
                //计算不同页面的结束颜色，最后一张的颜色是第一个颜色，其他的分别加一
                endColor = position == colors.length - 1 ? colors[0] : colors[position + 1];
                //根据positionOffset得到渐变色，因为positionOffset本身为0~1之间的小数所以无需多做处理了
                int evaluate = (int) evaluator.evaluate(positionOffset, colors[position], endColor);

                //最后设置渐变背景色给布局
                viewpager.setBackgroundColor(evaluate);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
