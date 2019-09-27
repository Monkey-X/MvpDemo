package com.xu.mvp.Ibase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected  View mView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = LayoutInflater.from(this).inflate(getLayoutId(), null);
        setContentView(mView);
        init(savedInstanceState);
    }

    protected abstract int getLayoutId();

    protected abstract void init(Bundle savedInstanceState);
}
