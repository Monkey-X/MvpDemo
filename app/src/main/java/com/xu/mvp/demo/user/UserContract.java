package com.xu.mvp.demo.user;

import com.xu.mvp.Ibase.IBaseView;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:
 */
public interface UserContract {

    interface View extends IBaseView{
        void showUser(String msg);
    }

    interface  Presenter{
        void getUser(String userName);
    }
}
