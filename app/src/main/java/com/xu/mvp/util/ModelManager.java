package com.xu.mvp.util;

import com.xu.mvp.Ibase.IBaseModel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:Model的管理类
 */
public class ModelManager {


    private final ConcurrentHashMap<Class<? extends IBaseModel>, ? extends IBaseModel> DATA_CACHE;

    private ModelManager() {
        DATA_CACHE = new ConcurrentHashMap<>(8);
    }


    public static ModelManager getInstance() {
        return Holder.INSTANCE;
    }


    private static class Holder {
        private static final ModelManager INSTANCE = new ModelManager();
    }


    public <M extends IBaseModel> M create(final Class<M> clazz) {
        IBaseModel model = DATA_CACHE.get(clazz);
        if (model != null) {
            return (M) model;
        }

        synchronized (DATA_CACHE){
            model = DATA_CACHE.get(clazz);
            if (model == null) {
                try {
                    Constructor<M> constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    model = constructor.newInstance();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return (M) model;

    }
}
