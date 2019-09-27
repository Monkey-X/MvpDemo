package com.xu.mvp;

import com.xu.mvp.Ibase.BaseMvpActivity;
import com.xu.mvp.demo.orgs.OrgContract;
import com.xu.mvp.demo.user.UserContract;
import com.xu.mvp.demo.user.UserPresenter;

public class MainActivity extends BaseMvpActivity<UserPresenter> implements UserContract.View, OrgContract.View {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected UserPresenter getPresenter() {
        return new UserPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showOrg(String org) {

    }

    @Override
    public void showUser(String msg) {

    }
}
