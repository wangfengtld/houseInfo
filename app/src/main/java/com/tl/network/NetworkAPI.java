package com.tl.network;


import com.google.gson.reflect.TypeToken;
import com.tl.houseinfo.Constants;
import com.tl.model.Image;

import java.util.List;

import okhttp3.Request;

/**
 * Created by aspsine on 16/4/6.
 */
public class NetworkAPI {

    public static void requestImages(int page, final Callback<List<Image>> callback) {
        String url = Constants.ImagesAPI(page);
        final Request request = new Request.Builder().get().url(url).build();
        OkHttp.getOkHttpClient().newCall(request).enqueue(new GsonCallbackWrapper<List<Image>>(callback, new TypeToken<List<Image>>() {
        }));
    }

    public static void requestBanners(final Callback<List<Image>> callback) {
        String url = Constants.BannerAPI;
        final Request request = new Request.Builder().get().url(url).build();
        OkHttp.getOkHttpClient().newCall(request).enqueue(new GsonCallbackWrapper<List<Image>>(callback, new TypeToken<List<Image>>() {
        }));
    }

    public interface Callback<T> {
        void onSuccess(T t);

        void onFailure(Exception e);
    }
}
