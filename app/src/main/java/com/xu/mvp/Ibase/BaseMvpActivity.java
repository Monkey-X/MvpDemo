package com.xu.mvp.Ibase;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.ArraySet;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:
 */
@RequiresApi(api = Build.VERSION_CODES.M)
public abstract class BaseMvpActivity<P extends IBasePresenter<? extends IBaseView>> extends BaseActivity implements IBaseView {


    //主Presenter
    protected P mPresenter;
    //添加多个P的情况
    private ArraySet<IBasePresenter> mPresenters = new ArraySet<>(4);

    @Override
    protected void init(Bundle savedInstanceState) {
        mPresenter = getPresenter();
        addToPresenters(mPresenter);
        initView();
        initData();
    }

    protected abstract P getPresenter();

    protected abstract void initView();

    protected abstract void initData();

    protected <T extends IBasePresenter> void addToPresenters(T presenter) {
        presenter.attachView(this);
        mPresenters.add(presenter);
    }

    @Override
    protected void onDestroy() {
        for (IBasePresenter presenter : mPresenters) {
            presenter.detachView();
        }
        mPresenters.clear();
        super.onDestroy();
    }
}
