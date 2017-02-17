package com.kingsoft.zkdemo.recylerview.stickyheader;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kingsoft.zkdemo.R;

import tellh.com.stickyheaderview_rv.adapter.StickyHeaderViewAdapter;
import tellh.com.stickyheaderview_rv.adapter.ViewBinder;


public class UserItemViewBinder extends ViewBinder<User, UserItemViewBinder.ViewHolder> {
    @Override
    public ViewHolder provideViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public void bindView(StickyHeaderViewAdapter adapter, ViewHolder holder, int position, User entity) {
        holder.tvId.setText(String.valueOf(entity.getId()));
        holder.tvName.setText(entity.getLogin());
        Glide.with(holder.ivAvatar.getContext())
                .load(entity.getAvatar_url())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ivAvatar);
    }

    @Override
    public int getItemLayoutId(StickyHeaderViewAdapter adapter) {
        return R.layout.item_user;
    }

    static class ViewHolder extends ViewBinder.ViewHolder {
        public TextView tvId;
        public ImageView ivAvatar;
        public TextView tvName;

        public ViewHolder(View rootView) {
            super(rootView);
            this.tvId = (TextView) rootView.findViewById(R.id.tv_id);
            this.ivAvatar = (ImageView) rootView.findViewById(R.id.iv_avatar);
            this.tvName = (TextView) rootView.findViewById(R.id.tv_name);
        }

    }
}
