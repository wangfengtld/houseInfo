package com.tl.model;

import java.util.List;

public class GetHouseEstatesByProject<T> {

    private int     Code;
    private String  ErrMsg;
    private List<T> HouseEstates;

    public GetHouseEstatesByProject() {
    }

    public GetHouseEstatesByProject(int code, String errMsg, List<T> houseEstates) {
        Code = code;
        ErrMsg = errMsg;
        HouseEstates = houseEstates;
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

    public List<T> getHouseEstates() {
        return HouseEstates;
    }

    public void setHouseEstates(List<T> houseEstates) {
        HouseEstates = houseEstates;
    }
}
