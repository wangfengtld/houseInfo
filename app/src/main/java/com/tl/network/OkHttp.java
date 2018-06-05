package com.tl.network;

import android.content.Context;


import com.parkingwang.okhttp3.LogInterceptor.LogInterceptor;
import com.tl.houseinfo.BuildConfig;
import com.tl.utils.FileUtils;

import okhttp3.Cache;
import okhttp3.OkHttpClient;


public class OkHttp {
    private static final int MAX_CACHE_SIZE = 200 * 1024 * 1024;
    private static OkHttpClient sOkHttpClient;

    public static void init(Context context) {
        Context applicationContext = context.getApplicationContext();


        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
            .cache(new Cache(FileUtils.getHttpCacheDir(applicationContext), MAX_CACHE_SIZE));

        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(new LogInterceptor());
        }
        sOkHttpClient = clientBuilder.build();
    }

    public static OkHttpClient getOkHttpClient() {
        return sOkHttpClient;
    }
}
