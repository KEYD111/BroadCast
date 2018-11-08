package com.example.dadac.rockserialportgetangle;


import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private static int i = 0;

    private Button DC_Button_Jump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myThread.start();
        DC_Button_Jump = (Button) findViewById(R.id.DC_Button_Jump);

    }


    Thread myThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                i++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = new Message();
                msg.what = 0x01;
                msg.obj = i;
                myhandler.sendMessage(msg);
            }
        }
    });

    public Handler myhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x01:
                    Log.i("dachenSend", msg.obj.toString());
                    StareBroadCast(msg.obj.toString());
                    break;
                default:

                    break;
            }
        }
    };

    /**
     * @Function: 开始广播消息
     * @Return:
     */
    private void StareBroadCast(String broadcastmsg) {
        //创建Intent对象
        Intent intentBroadCast = new Intent();
        //设置Intent的Action的属性
        intentBroadCast.setAction("BroadCast.test");
        intentBroadCast.putExtra("msg_test", broadcastmsg);
        //发送广播
        sendBroadcast(intentBroadCast);
    }

    //用于匿名内部类的
    public void jump(View view) {
        Intent myIntent2 = new Intent(MainActivity.this, TestActivity.class);
        startActivity(myIntent2);
    }
}
































