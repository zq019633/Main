package com.mantis.icpMain;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ipc.MessageEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xiaofei.library.hermeseventbus.HermesEventBus;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HermesEventBus.getDefault().register(this);
        initView();

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getNextActivityMessage(MessageEvent nextMessage){

    }

    private void initView() {
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("点击","====");
                HermesEventBus.getDefault().post( new MessageEvent("input tap 35 276") );
                Log.i("点击","发送消息");
            }
        });
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"点击了",Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onDestroy() {
        // unregister
        HermesEventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
