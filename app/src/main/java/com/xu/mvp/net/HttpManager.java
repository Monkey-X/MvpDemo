package com.xu.mvp.net;

import org.jetbrains.annotations.NotNull;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:
 */
public class HttpManager {

    private String baseUrl;
    private OkHttpClient mOkHttpClient;

    private Retrofit mRetrofit;

    private static final Logger LOG = Logger.getLogger(HttpManager.class.getName());

    private HttpManager() {
    }

    private boolean debug = true;


    public static HttpManager getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static HttpManager INSTANCE = new HttpManager();
    }


    public HttpManager setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return Holder.INSTANCE;
    }

    public HttpManager setOkhttpClient(OkHttpClient okhttpClient) {
        this.mOkHttpClient = okhttpClient;
        return Holder.INSTANCE;
    }


    public void setRetrofit(Retrofit retrofit) {
        this.mRetrofit = retrofit;
    }


    public <T> T getApiService(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }


    public Retrofit createRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(mOkHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(ObserveOnMainCallAdapterFactory.createMainScheduler())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()));
        return builder.build();

    }


    public OkHttpClient createDefaultClient() {
        final int timeOut = 10;
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .proxy(Proxy.NO_PROXY);
        if (debug) {
            builder.addInterceptor(new HttpLoggingInterceptor(new InterceptorLogInfo()));
        }

        return builder.build();
    }

    public static class InterceptorLogInfo implements HttpLoggingInterceptor.Logger {

        @Override
        public void log(@NotNull String s) {
            LOG.log(Level.INFO, s);
        }
    }
}
