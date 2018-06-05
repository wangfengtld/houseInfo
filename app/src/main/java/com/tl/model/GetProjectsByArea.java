package com.tl.model;

import java.util.List;

public class GetProjectsByArea<T> {

    private int     Code;
    private String  ErrMsg;
    private List<T> Projects;

    public GetProjectsByArea() {
    }

    public GetProjectsByArea(int code, String errMsg, List<T> projects) {
        Code = code;
        ErrMsg = errMsg;
        Projects = projects;
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

    public List<T> getProjects() {
        return Projects;
    }

    public void setProjects(List<T> projects) {
        Projects = projects;
    }
}
