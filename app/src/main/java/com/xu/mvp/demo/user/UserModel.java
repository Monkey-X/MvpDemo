package com.xu.mvp.demo.user;

import com.xu.mvp.baseImpl.BaseModle;
import com.xu.mvp.net.HttpResultObserve;

import io.reactivex.disposables.Disposable;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:
 */
public class UserModel extends BaseModle {


    public Disposable getUser(String userName, HttpResultObserve<String> observe){
        return getApiService().getUser(userName).subscribeWith(observe);
    }

}
