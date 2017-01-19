package com.kingsoft.zkdemo.refresh.neteasyrefresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kingsoft.zkdemo.R;

public class NetEasyRefreshActivity extends AppCompatActivity {

//    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_neteasy);
//        listView = (ListView) findViewById(R.id.listView);
        final RefreshLayout refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        if (refreshLayout != null) {
            // 刷新状态的回调
            refreshLayout.setRefreshListener(new RefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    // 延迟3秒后刷新成功
                    refreshLayout.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            refreshLayout.refreshComplete();
//                            if (listView != null) {
//                                listView.setAdapter(new MainAdapter());
//                            }
                        }
                    }, 3000);
                }
            });
            NetEasyHeadView shopView = new NetEasyHeadView(this);
//            TextView tv = new TextView(this);
//            tv.setText("test");
            refreshLayout.setRefreshHeader(shopView);
//            refreshLayout.setRefreshHeader(tv);
            refreshLayout.autoRefresh();
        }

    }


}
