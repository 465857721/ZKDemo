package com.kingsoft.zkdemo.main;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by 周康 on 2017/1/6.
 */

public class Tools {
    private static Toast toast;

    /**
     * @param context
     * @param msg
     */
    public static void toastInBottom(Context context, String msg) {
        if (context != null) {
            if (toast == null) {
                toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            } else {
                toast.setText(msg);
            }
            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 300);
            toast.show();
        }

    }
}
