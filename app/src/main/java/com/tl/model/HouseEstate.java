package com.tl.model;

public class HouseEstate {

    private int HouseEstateId;
    private String ProjectNumber;
    private String ProjectName;
    private String HouseEstateName;

    public HouseEstate() {
    }

    public HouseEstate(int houseEstateId, String projectNumber, String projectName, String houseEstateName) {
        HouseEstateId = houseEstateId;
        ProjectNumber = projectNumber;
        ProjectName = projectName;
        HouseEstateName = houseEstateName;
    }

    public int getHouseEstateId() {
        return HouseEstateId;
    }

    public void setHouseEstateId(int houseEstateId) {
        HouseEstateId = houseEstateId;
    }

    public String getProjectNumber() {
        return ProjectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        ProjectNumber = projectNumber;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getHouseEstateName() {
        return HouseEstateName;
    }

    public void setHouseEstateName(String houseEstateName) {
        HouseEstateName = houseEstateName;
    }
}
