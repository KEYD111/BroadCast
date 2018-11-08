package com.example.dadac.rockserialportgetangle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @ Create by dadac on 2018/10/10.
 * @Function:
 * @Return:
 */
public class MyBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("dachenReceiveExtends", intent.getAction() + "\t消息内容是：" + intent.getStringExtra("msg_test"));
    }
}
