package com.mantis.icpMain;

import android.app.Application;

import xiaofei.library.hermeseventbus.HermesEventBus;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HermesEventBus.getDefault().init(this);
    }
}
