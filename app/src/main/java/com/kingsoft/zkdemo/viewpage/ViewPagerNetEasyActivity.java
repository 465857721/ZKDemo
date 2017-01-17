package com.kingsoft.zkdemo.viewpage;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
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

/**
 * http://blog.csdn.net/u011200844/article/details/44458395
 * http://www.jianshu.com/p/c9bbf9f4bf06
 */
public class ViewPagerNetEasyActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    int endColor;
    @BindView(R.id.tab_discoverfragment_title)
    TabLayout tabLayout;
    private View view1, view2, view3, view4, view5, view6, view7, view8, view9;
    private List<View> viewList;//view数组
    //这是我三个页面分别用到的背景色
//    private int colors[] = {Color.RED, Color.BLUE, Color.GREEN};
    private ArrayList<String> list_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_neteasy);
        ButterKnife.bind(this);

        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.view1, null);
        view2 = inflater.inflate(R.layout.view2, null);
        view3 = inflater.inflate(R.layout.view3, null);
        view4 = inflater.inflate(R.layout.view1, null);
        view5 = inflater.inflate(R.layout.view2, null);
        view6 = inflater.inflate(R.layout.view3, null);
        view7 = inflater.inflate(R.layout.view1, null);
        view8 = inflater.inflate(R.layout.view2, null);
        view9 = inflater.inflate(R.layout.view3, null);


        viewList = new ArrayList<>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
        viewList.add(view5);
        viewList.add(view6);
        viewList.add(view7);
        viewList.add(view8);
        viewList.add(view9);
        list_title = new ArrayList<>();
        list_title.add("头条");
        list_title.add("科技");
        list_title.add("娱乐");
        list_title.add("头条");
        list_title.add("科技");
        list_title.add("娱乐");
        list_title.add("头条");
        list_title.add("科技");
        list_title.add("娱乐");
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
            public void destroyItem(ViewGroup container, int position, Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));
                return viewList.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return list_title.get(position);
            }
        };


        viewpager.setAdapter(pagerAdapter);


        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewpager);
        //http://blog.csdn.net/noaboutfengyue/article/details/50354592
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("zk position=", "" + position);
                Log.d("zk positionOffset=", "" + positionOffset);
                Log.d("zk ", "positionOffsetPixels=" + positionOffsetPixels);

//                //得到 颜色 估值器
//                ArgbEvaluator evaluator = new ArgbEvaluator();
//                //给布局设置初始颜色
//                viewpager.setBackgroundColor(colors[position]);
//                //计算不同页面的结束颜色，最后一张的颜色是第一个颜色，其他的分别加一
//                endColor = position == colors.length - 1 ? colors[0] : colors[position + 1];
//                //根据positionOffset得到渐变色，因为positionOffset本身为0~1之间的小数所以无需多做处理了
//                int evaluate = (int) evaluator.evaluate(positionOffset, colors[position], endColor);

                //最后设置渐变背景色给布局
//                viewpager.setBackgroundColor(evaluate);
                tabLayout.getTabAt(position).getCustomView().setScaleX(positionOffset);

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
