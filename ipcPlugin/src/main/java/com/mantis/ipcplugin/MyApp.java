package com.mantis.ipcplugin;

import android.app.Application;

import xiaofei.library.hermeseventbus.HermesEventBus;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HermesEventBus.getDefault().connectApp(this, "com.mantis.icpMain");
    }
}
