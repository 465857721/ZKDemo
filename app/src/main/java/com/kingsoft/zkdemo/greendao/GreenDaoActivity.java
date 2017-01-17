package com.kingsoft.zkdemo.greendao;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.anye.greendao.gen.UserDao;
import com.kingsoft.zkdemo.R;
import com.kingsoft.zkdemo.main.MyApplication;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GreenDaoActivity extends AppCompatActivity {

    @BindView(R.id.et_add)
    EditText etAdd;
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.et_modify)
    EditText etModify;
    @BindView(R.id.btn_modify)
    Button btnModify;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.listview)
    ListView listview;
    private UserDao mUserDao;

    private Sadapter sadapter;
    private List<User> userlist;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_green_dao);
        ButterKnife.bind(this);
        userlist = new ArrayList<>();
        sadapter = new Sadapter();
        mUserDao = MyApplication.getInstances().getDaoSession().getUserDao();
        listview.setAdapter(sadapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mUserDao.deleteByKey(userlist.get(position).getId());
                userlist = mUserDao.loadAll();
                sadapter.notifyDataSetChanged();
            }
        });
    }

    @OnClick({R.id.btn_add, R.id.btn_modify, R.id.btn_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                User mUser = new User(null, etAdd.getText().toString());
                mUserDao.insert(mUser);//添加一个
                userlist.clear();
                userlist = mUserDao.loadAll();
                sadapter.notifyDataSetChanged();
                break;
            case R.id.btn_modify:
                User mUser2 = new User((long) 1, etModify.getText().toString());
                mUserDao.update(mUser2);
                userlist = mUserDao.loadAll();
                sadapter.notifyDataSetChanged();
                break;
            case R.id.btn_search:
                userlist.clear();
                userlist = mUserDao.loadAll();
                sadapter.notifyDataSetChanged();
                break;
        }
    }

    class Sadapter extends android.widget.BaseAdapter {


        @Override
        public int getCount() {
            return userlist.size();
        }

        @Override
        public User getItem(int position) {
            return userlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = new TextView(mContext);
            tv.setText("id=" + userlist.get(position).getId() + " name = " + userlist.get(position).getName());
            return tv;
        }
    }


//    1. 增
//
//            mUser = new User((long)2,"anye3");
//    mUserDao.insert(mUser);//添加一个
//    2. 删
//
//    mUserDao.deleteByKey(id);
//    3. 改
//
//            mUser = new User((long)2,"anye0803");
//    mUserDao.update(mUser);
//    4. 查
//
//    List<User> users = mUserDao.loadAll();
//    String userName = "";
//    for (int i = 0; i < users.size(); i++) {
//        userName += users.get(i).getName()+",";
//    }
//    mContext.setText("查询全部数据==>"+userName);
}
