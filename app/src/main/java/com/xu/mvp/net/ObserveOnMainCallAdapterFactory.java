package com.xu.mvp.net;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.Nullable;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import io.reactivex.Single;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:
 */
public class ObserveOnMainCallAdapterFactory extends CallAdapter.Factory {

    private final Scheduler mScheduler;


    public ObserveOnMainCallAdapterFactory(Scheduler scheduler) {
        this.mScheduler = scheduler;
    }


    @Nullable
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Class<?> rawType = getRawType(returnType);
        if (rawType != Single.class) {
            return null;
        }
        final CallAdapter<Object, Single<?>> delegate = (CallAdapter<Object, Single<?>>) retrofit.nextCallAdapter(this, returnType, annotations);
        return new CallAdapter<Object, Object>() {
            @Override
            public Type responseType() {
                return delegate.responseType();
            }

            @Override
            public Object adapt(Call<Object> call) {
                Single<?> single = delegate.adapt(call);
                return single.observeOn(mScheduler);
            }
        };


    }

    public static CallAdapter.Factory createMainScheduler(){
        return new ObserveOnMainCallAdapterFactory(AndroidSchedulers.mainThread());
    }
}
