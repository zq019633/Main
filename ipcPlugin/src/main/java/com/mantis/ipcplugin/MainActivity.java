package com.mantis.ipcplugin;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void  getMainAppEvent(MessageEvent event){
        Toast.makeText( MainActivity.this, "Plugin APP 方法被调用", Toast.LENGTH_SHORT ).show();
        Log.i("接收主app","="+event.getMessage());

    }

    @Override
    protected void onDestroy() {
        HermesEventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
