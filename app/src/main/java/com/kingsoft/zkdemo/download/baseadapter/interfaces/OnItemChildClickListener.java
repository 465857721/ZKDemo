package com.kingsoft.zkdemo.download.baseadapter.interfaces;

import com.kingsoft.zkdemo.download.baseadapter.ViewHolder;

/**
 * Author: Othershe
 * Time: 2016/8/29 10:48
 */
public interface OnItemChildClickListener<T> {
    void onItemChildClick(ViewHolder viewHolder, T data, int position);
}
