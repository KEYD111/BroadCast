package com.example.dadac.rockserialportgetangle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * @ Create by dadac on 2018/10/10.
 * @Function:
 * @Return:
 */
public class TestActivity extends AppCompatActivity {

    private MyBroadCastReceiver2 myBroadCastReceiver2;

    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        myBroadCastReceiver2 = new MyBroadCastReceiver2();
        // 创建IntentFilter
        IntentFilter filter = new IntentFilter();
        // 指定BroadcastReceiver监听的Action
        filter.addAction("BroadCast.test");
        // 注册BroadcastReceiver
        registerReceiver(myBroadCastReceiver2, filter);
    }

    class MyBroadCastReceiver2 extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // a=intent.getStringExtra("msg_test");
            Log.i("dachenReceiveNew", intent.getAction() + "\t消息内容是：" + intent.getStringExtra("msg_test"));
        }
    }


}
