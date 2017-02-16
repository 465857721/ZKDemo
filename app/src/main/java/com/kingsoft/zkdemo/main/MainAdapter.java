package com.kingsoft.zkdemo.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kingsoft.zkdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 周康 on 2017/2/16.
 */

public class MainAdapter extends RecyclerView.Adapter {
    private DemoBean[] arr;
    private Context context;

    public MainAdapter(DemoBean[] arr, Context context) {
        this.arr = arr;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainItemHoler(LayoutInflater.from(context).inflate(R.layout.item_homelist, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MainItemHoler mh = (MainItemHoler) holder;
        final DemoBean bean = arr[position];
        mh.tvName.setText(bean.getName());
        mh.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, bean.getMclass());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    class MainItemHoler extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;

        public MainItemHoler(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
