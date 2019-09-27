package com.xu.mvp.Ibase;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:
 */
public interface IBaseView {

    void showMsg(String msg);


    void showLoading();

    void showLoading(String msg);

    void hideLoading();
}
