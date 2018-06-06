package com.tl.model;

public class Project {

    private int     ID;
    private String  Number;
    private String  Name;
    private String  Address;
    private String  ProjectArea;
    private String  DevelopCompany;
    private String  IdentityNumber;
    private boolean IsEnd;
    private String  EndReason;


    public Project() {
    }

    public Project(int ID, String number, String name, String address, String projectArea, String developCompany, String identityNumber, boolean isEnd, String endReason) {
        this.ID = ID;
        Number = number;
        Name = name;
        Address = address;
        ProjectArea = projectArea;
        DevelopCompany = developCompany;
        IdentityNumber = identityNumber;
        IsEnd = isEnd;
        EndReason = endReason;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getProjectArea() {
        return ProjectArea;
    }

    public void setProjectArea(String projectArea) {
        ProjectArea = projectArea;
    }

    public String getDevelopCompany() {
        return DevelopCompany;
    }

    public void setDevelopCompany(String developCompany) {
        DevelopCompany = developCompany;
    }

    public String getIdentityNumber() {
        return IdentityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        IdentityNumber = identityNumber;
    }

    public boolean isEnd() {
        return IsEnd;
    }

    public void setEnd(boolean end) {
        IsEnd = end;
    }

    public String getEndReason() {
        return EndReason;
    }

    public void setEndReason(String endReason) {
        EndReason = endReason;
    }
}
