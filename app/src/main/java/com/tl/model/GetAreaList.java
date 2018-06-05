package com.tl.model;

import java.util.List;

public class GetAreaList<T> {

    private int Code;
    private String ErrMsg;
    private List<T> AreaList;

    public GetAreaList() {
    }

    public GetAreaList(int code, String errMsg, List<T> areaList) {
        Code = code;
        ErrMsg = errMsg;
        AreaList = areaList;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getErrMsg() {
        return ErrMsg;
    }

    public void setErrMsg(String errMsg) {
        ErrMsg = errMsg;
    }

    public List<T> getAreaList() {
        return AreaList;
    }

    public void setAreaList(List<T> areaList) {
        AreaList = areaList;
    }
}
