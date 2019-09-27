package com.xu.mvp.demo.orgs;

import com.xu.mvp.Ibase.IBasePresenter;
import com.xu.mvp.net.HttpResultObserve;

import io.reactivex.disposables.Disposable;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:
 */
public class OrgPresenter extends IBasePresenter<OrgContract.View> implements OrgContract.Presenter {

    private OrgModel mModel;

    private Disposable mDisposable;

    public OrgPresenter(){
        mModel = getModel(OrgModel.class);
    }

    @Override
    public void getOrg(String org) {
        if (isNullOrDisposed(mDisposable)) {
            return;
        }

        mDisposable = mModel.getOrg(org, new HttpResultObserve<String>() {
            @Override
            protected void onResult(String s) {

            }

            @Override
            protected void onFailure(Throwable e) {

            }
        });

        addDisposable(mDisposable);
    }
}
