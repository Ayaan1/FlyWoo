package com.zjk.wifiproject.activity.wifiap;

import android.content.Context;

import com.zjk.wifiproject.base.BaseActivity;
import com.zjk.wifiproject.chat.ChatActivity;
import com.zjk.wifiproject.socket.udp.UDPMessageListener;

import java.util.Stack;


/**
 * @fileName ActivityCollectorUtils.java
 * @package szu.wifichat.android.util
 * @description 活动管理类
 **/
public class ActivitiesManager {

    private static Stack<BaseActivity> queue;
    private static UDPMessageListener mListener;
    private static ChatActivity mChatActivity;

    public static void init(Context context) {
        queue = new Stack<BaseActivity>();
        mListener = UDPMessageListener.getInstance(context);
    }

    public static void addActivity(BaseActivity activity) {
        queue.add(activity);
    }

    public static void finishActivity(BaseActivity activity) {
        if (activity != null) {
            queue.remove(activity);
        }
    }

    public static void finishAllActivities() {
        mListener.notifyOffline();
        mListener.stopUDPSocketThread();
        mListener = null;
        for (BaseActivity activity : queue) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        queue.clear();
    }

    public static int getActivitiesNum() {
        if (!queue.isEmpty()) {
            return queue.size();
        }
        return 0;
    }

    public static BaseActivity getCurrentActivity() {
        if (!queue.isEmpty()) {
            return queue.lastElement();
        }
        return null;
    }

    public static void initChatActivity(ChatActivity pActivity) {
        mChatActivity = pActivity;
    }

    public static void removeChatActivity() {
        mChatActivity = null;
    }

    public static ChatActivity getChatActivity() {
        return mChatActivity;
    }

}
