package com.tl.model;

public class Area {

    private int ID;
    private String Name;
    private String CityName;

    public Area() {
    }

    public Area(int ID, String name, String cityName) {
        this.ID = ID;
        Name = name;
        CityName = cityName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }
}
