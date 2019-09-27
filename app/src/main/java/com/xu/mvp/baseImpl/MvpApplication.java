package com.xu.mvp.baseImpl;

import android.app.Application;

import com.xu.mvp.net.HttpManager;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:
 */
public class MvpApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpManager.getInstance().setBaseUrl("https://api.github.com/")
                .setOkhttpClient(HttpManager.getInstance().createDefaultClient())
                .setRetrofit(HttpManager.getInstance().createRetrofit());
    }
}
