package com.kingsoft.zkdemo.recylerview.stickyheader;

import com.kingsoft.zkdemo.R;

import tellh.com.stickyheaderview_rv.adapter.DataBean;
import tellh.com.stickyheaderview_rv.adapter.StickyHeaderViewAdapter;


public class ItemHeader extends DataBean {
    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    public ItemHeader(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public int getItemLayoutId(StickyHeaderViewAdapter adapter) {
        return R.layout.header;
    }

    @Override
    public boolean shouldSticky() {
        return true;
    }
}
