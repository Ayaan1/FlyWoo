package com.zjk.wifiproject.util;

import android.util.Log;

/**
 * ��־������
 */
public class L {
    public static boolean isDebug = true; // �Ƿ���Ҫ��ӡbug��������application��onCreate���������ʼ��
    private static final String TAG = "WifiLog";

    public static String fromHere() {
        String ret = "";
        if (isDebug) {
            StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
            StringBuffer toStringBuffer = new StringBuffer("[").append(traceElement.getFileName())
                    .append(" | ").append(traceElement.getMethodName()).append(" | ")
                    .append(traceElement.getLineNumber()).append("]");
            ret = toStringBuffer.toString();
        }
        return ret;
    }

    // �����ĸ���Ĭ��tag�ĺ���
    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, "..............." + msg);
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, "..............." + msg);
    }

    public static void e(String msg) {
        if (isDebug)
            Log.e(TAG, "..............." + msg);
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, "..............." + msg);
    }

    // �����Ǵ����Զ���tag�ĺ���
    public static void i(String tag, String msg) {
        if (isDebug)
            Log.i(tag, "..............." + msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.i(tag, "..............." + msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.i(tag, "..............." + msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.i(tag, "..............." + msg);
    }
}
