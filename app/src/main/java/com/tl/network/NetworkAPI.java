package com.tl.network;


import com.google.gson.reflect.TypeToken;
import com.tl.houseinfo.Constants;
import com.tl.model.Area;
import com.tl.model.GetAreaList;
import com.tl.model.GetHouseEstatesByProject;
import com.tl.model.GetProjectsByArea;
import com.tl.model.HouseEstate;
import com.tl.model.Image;
import com.tl.model.Project;

import java.util.List;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;


public class NetworkAPI {

    private static String HOST = "https://www.weiyouming.com:8080/api/";
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

    public static void requestAreaList(final Callback<GetAreaList<Area>> callback) {
        String url = HOST + "GetAreaList";
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("CityName","");
        RequestBody formBody = builder.build();
//        String token = "";
        final Request request = new Request.Builder().post(formBody).url(url).build();
        OkHttp.getOkHttpClient().newCall(request).enqueue(new GsonCallbackWrapper<GetAreaList<Area>>(callback, new TypeToken<GetAreaList<Area>>() {
        }));
    }

    public static void requestProjectsByArea(int areaId, final Callback<GetProjectsByArea<Project>> callback) {
        String url = HOST + "GetProjectsByArea";
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("AreaId",areaId + "");
        RequestBody formBody = builder.build();
//        String token = "";
        final Request request = new Request.Builder().post(formBody).url(url).build();
        OkHttp.getOkHttpClient().newCall(request).enqueue(new GsonCallbackWrapper<GetProjectsByArea<Project>>(callback, new TypeToken<GetProjectsByArea<Project>>() {
        }));
    }

    public static void requestHouseEstatesByProject(int projectId, final Callback<GetHouseEstatesByProject<HouseEstate>> callback) {
        String url = HOST + "GetHouseEstatesByProject";
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("ProjectId",projectId + "");
        RequestBody formBody = builder.build();
//        String token = "";
        final Request request = new Request.Builder().post(formBody).url(url).build();
        OkHttp.getOkHttpClient().newCall(request).enqueue(new GsonCallbackWrapper<GetHouseEstatesByProject<HouseEstate>>(callback, new TypeToken<GetHouseEstatesByProject<HouseEstate>>() {
        }));
    }

    public interface Callback<T> {
        void onSuccess(T t);

        void onFailure(Exception e);
    }
}
