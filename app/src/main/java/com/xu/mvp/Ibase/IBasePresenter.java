package com.xu.mvp.Ibase;

import com.xu.mvp.util.ModelManager;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:
 */
public abstract class IBasePresenter<V extends IBaseView> {


    protected V view;


    private CompositeDisposable mDisposable;


    /**
     * 绑定view
     * @param view
     * @param <T>
     */
    public <T extends IBaseView> void attachView(T view){
        this.view = ((V) view);
        mDisposable = new CompositeDisposable();
    }


    /**
     * 解绑view
     */
    public void detachView(){
        mDisposable.clear();
        mDisposable = null;
        view =null;
    }


    /**
     * 添加Disposable 到 CompositeDisposable，通过解除disposable处理内存泄露的问题
     * @param disposable
     * @return
     */
    protected boolean addDisposable (Disposable disposable){
        if (isNullOrDisposed(disposable)) {
            return false;
        }
        return mDisposable.add(disposable);
    }

    /**
     * 判断d 是否为空或者dispose已结束
     * @param d
     * @return
     */
    protected boolean isNullOrDisposed(Disposable d){
        return d == null || d.isDisposed();
    }



    protected <M extends IBaseModel> M getModel(Class<M> clazz){
        return ModelManager.getInstance().create(clazz);
    }
}
