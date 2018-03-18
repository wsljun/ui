package com.cj.reocrd.ui.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    /**
     * 显示一个小提示框(int)
     *
     * @param pContext
     * @param message
     */
    public static void showToastS(final Context pContext, final int message) {
        showToast(pContext, message, Toast.LENGTH_SHORT);
    }

    /**
     * 显示一个小提示框(CharSequence)
     *
     * @param pContext
     * @param message
     */
    public static void showToastS(final Context pContext, final CharSequence message) {
        showToast(pContext, message, Toast.LENGTH_SHORT);
    }

    /**
     * 显示一个小提示框(int)
     *
     * @param pContext
     * @param message
     */
    public static void showToastL(final Context pContext, final int message) {
        showToast(pContext, message, Toast.LENGTH_LONG);
    }

    /**
     * 显示一个小提示框(CharSequence)
     *
     * @param pContext
     * @param message
     */
    public static void showToastL(final Context pContext, final CharSequence message) {
//        Looper.prepare();
        showToast(pContext, message, Toast.LENGTH_LONG);
//        Looper.loop();
    }

    /**
     * 将int的参数转为String的函数
     */
    public static void showToast(final Context pContext, final int message, final int duration) {
        showToast(pContext, pContext.getString(message), duration);
    }

    /**
     * 显示一个小提示框 主封装
     *
     * @param pContext
     * @param message
     * @param duration
     */
    public static void showToast(final Context pContext, CharSequence message, int duration) {
        Toast toast = Toast.makeText(pContext, message, duration);
        toast.show();
    }
}