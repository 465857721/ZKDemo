package com.kingsoft.zkdemo.download.Utils;

import android.content.Context;

import com.kingsoft.zkdemo.download.download.DBuilder;


public class DUtil {

    public static DBuilder init(Context context) {
        return new DBuilder(context);
    }
}
