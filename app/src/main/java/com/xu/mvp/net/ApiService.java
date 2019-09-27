package com.xu.mvp.net;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author:xlc
 * @date:2019/9/27
 * @descirbe:
 */
public interface ApiService {

    @GET("users/{username}")
    Single<String> getUser(@Path("username") String username);

    @GET("orgs/{org}")
    Single<String> getPrg(@Path("org") String org);

}
