package com.xu.mvp.baseImpl;

import com.xu.mvp.Ibase.IBaseModel;
import com.xu.mvp.net.ApiService;
import com.xu.mvp.net.HttpManager;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:
 */
public abstract class BaseModle implements IBaseModel {

    private ApiService mApiService;


    protected ApiService getApiService(){
        if (mApiService == null) {
            mApiService = HttpManager.getInstance().getApiService(ApiService.class);
        }
        return  mApiService;
    }
}
