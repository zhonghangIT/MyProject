package com.education.myanimation;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.leakcanary.LeakCanary;

import okhttp3.OkHttpClient;

/**
 * Created by zhonghang on 16/7/25.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //此处做很多更新,会耗时,会卡屏,会出现白屏,怎么解决这个问题,不知道呢
        //初始化内存溢出的检查方法
        LeakCanary.install(this);
        //此处进行fresco的初始化,必须支持gif以及webp替换其中的网络连接的方式为okhttp
        OkHttpClient client = new OkHttpClient();
        Fresco.initialize(this);
    }
}
