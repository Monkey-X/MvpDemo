package com.xu.mvp.demo.orgs;

import com.xu.mvp.baseImpl.BaseModle;
import com.xu.mvp.net.HttpResultObserve;

import io.reactivex.disposables.Disposable;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe: 相关数据的model
 */
public class OrgModel extends BaseModle {

    public Disposable getOrg(String org, HttpResultObserve<String> observe){
        return getApiService().getPrg(org).subscribeWith(observe);
    }
}
