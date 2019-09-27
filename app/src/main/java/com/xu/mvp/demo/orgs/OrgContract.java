package com.xu.mvp.demo.orgs;

import com.xu.mvp.Ibase.IBaseView;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:契约类，管理view和Presenter
 */
public interface OrgContract {

    interface  View extends IBaseView{
        void showOrg(String org);
    }


    interface Presenter{
        void getOrg(String org);
    }


}
