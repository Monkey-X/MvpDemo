package com.xu.mvp.net;

import io.reactivex.observers.DisposableSingleObserver;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:
 */
public abstract class HttpResultObserve<T> extends DisposableSingleObserver<T> {
    @Override
    public void onSuccess(T t) {
        dispose();
        onResult(t);
    }

    @Override
    public void onError(Throwable e) {
        dispose();
        onFailure(e);

    }

    protected abstract void onResult(T t);

    protected abstract void onFailure(Throwable e);
}
