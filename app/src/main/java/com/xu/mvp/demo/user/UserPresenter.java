package com.xu.mvp.demo.user;

import android.text.TextUtils;

import com.xu.mvp.Ibase.IBasePresenter;
import com.xu.mvp.net.HttpResultObserve;

import io.reactivex.disposables.Disposable;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:
 */
public class UserPresenter extends IBasePresenter<UserContract.View> implements UserContract.Presenter {

    private UserModel mModel;

    public UserPresenter() {
        mModel = getModel(UserModel.class);
    }

    @Override
    public void getUser(String userName) {
        if (TextUtils.isEmpty(userName)) {
            return;
        }

        Disposable disposable = mModel.getUser(userName, new HttpResultObserve<String>() {
            @Override
            protected void onResult(String s) {

            }

            @Override
            protected void onFailure(Throwable e) {

            }
        });
        addDisposable(disposable);
    }
}
